//Captcha component @0-B23D5113
package com.codecharge.components;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.text.MessageFormat;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.codecharge.events.Event;
import com.codecharge.events.CaptchaListener;
import com.codecharge.util.ContextStorage;
import com.codecharge.util.SessionStorage;

public class Captcha extends Component {

	private int imageHeight;
	private int imageWidth;
	private int length;
	private int rotation;
	private int broke;
	private int noise;
	private double hAmplitude;
	private double vAmplitude;
	private String sessionVariableName; 
	private String lettersFile;
	private ServletContext servletContext;
	private boolean caseSensitive;
	
	static Random rand = new Random();
	
	public Captcha(String name) {
		super(name);
	}
	
	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	public int getBroke() {
		return broke;
	}

	public void setBroke(int broke) {
		this.broke = broke;
	}

	public double getHAmplitude() {
		return hAmplitude;
	}

	public void setHAmplitude(double amplitude) {
		hAmplitude = amplitude;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getLettersFile() {
		return lettersFile;
	}

	public void setLettersFile(String lettersFile) {
		this.lettersFile = lettersFile;
	}

	public int getNoise() {
		return noise;
	}

	public void setNoise(int noise) {
		this.noise = noise;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public String getSessionVariableName() {
		return sessionVariableName;
	}

	public void setSessionVariableName(String sessionVariableName) {
		this.sessionVariableName = sessionVariableName;
	}

	public double getVAmplitude() {
		return vAmplitude;
	}

	public void setVAmplitude(double amplitude) {
		vAmplitude = amplitude;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	static int getRandomInt(int max) {
    	if (0 == max) {
    		return 0;
    	} else {
    	   	return rand.nextInt(max);
    	}
    }
    
    /** Add Captcha events handler to the list of listeners. **/
    public synchronized void addCaptchaListener(CaptchaListener l) {
        listeners.addElement(l);
    }

    /** Remove Captcha events handler from the list of listeners. **/
    public synchronized void removeButtonListener(CaptchaListener l) {
        listeners.removeElement(l);
    }

    public void fireOnValidateEvent() {
        Vector v;
        Event e = new Event(this); 
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((CaptchaListener)v.elementAt(i)).onValidate(e);
        }
    }

    public void fireBeforeShowEvent(Event e) {
        Vector l;
        this.setAttributes(this);
        e.setSource(this);
        synchronized(this) {l = (Vector)listeners.clone();}
        for (int i=0; i<l.size(); i++) {
            ((CaptchaListener)l.elementAt(i)).beforeShow(e);
        }
    }
	
    public boolean validate(String sessionValue, String captchaValue) {
    	if (null == captchaValue || "" == captchaValue || captchaValue.length() == 0) {
    		MessageFormat mFmt = new MessageFormat( res.getString("CCS_RequiredField") );
            mFmt.setLocale( pageModel.getLocale() );
            mFmt.applyPattern( res.getString("CCS_RequiredField") );

            StringBuffer result = new StringBuffer();
            mFmt.format(new String[] {this.getName()}, result, null);

    		this.addError(result.toString());
    		return false;
    	}
    	if (!this.isCaseSensitive() && captchaValue != null && sessionValue != null) {
    		captchaValue = captchaValue.toLowerCase();
            sessionValue = sessionValue.toLowerCase();
        }

		if (!captchaValue.trim().equals(sessionValue.trim())) {
			this.addError(res.getString("CCS_Captcha_ControlValidation"));
			return false;
		}

    	return true;
    }
    
	public String GenerateCaptchaCode(HttpServletRequest request) {
		ArrayList letters = this.getLetters();
		String restricted = "|cp|cb|ck|c6|c9|rn|rm|mm|co|do|cl|db|qp|qb|dp|";
        QuadraticPaths res = new QuadraticPaths();
        QuadraticPaths t;
        String code = " ";
        int i;
        int r;
        Random rand = new Random();
        for (i = 0; i < this.length; i++) {
            r = rand.nextInt(letters.size());
            while (restricted.indexOf("|" + code.substring(code.length()-1) + ((String)letters.get(r)).charAt(0) + "|") != -1) {
                r = rand.nextInt(letters.size());
            }
            code = code + ((String)letters.get(r)).charAt(0);
            t = new QuadraticPaths();
            t.LoadFromString((String)letters.get(r));
            t.Wave(2 * this.hAmplitude * rand.nextDouble() - this.hAmplitude);
            t.Rotate(Captcha.getRandomInt(2 * this.rotation) - this.rotation);
            t.Normalize(0, 100);
            if (t.getMaxX() - t.getMinX() > 100) {
                t.Normalize(100, 100);
            }
            t.Addition((i) * t.getMaxY(), 0);
            res.AddPaths(t);
        }
        res.Rotate(90);
        res.Wave(2 * this.vAmplitude * rand.nextDouble() - this.vAmplitude);
        res.Rotate(-90);
        res.Broke(this.broke, this.broke);
        res.Normalize(this.imageWidth - 12, this.imageHeight - 12);
        res.Addition(6, 6);
        res.Noises(this.noise);
        res.Mix();

        SessionStorage.getInstance( request ).setAttribute(this.sessionVariableName, code);

        return res.ToString();
	}
	
	private ArrayList getLetters() {
        Reader br = null;
        InputStream is = null;
        try {
            if ("false".equals( (String) ContextStorage.getInstance().getAttribute( "usedUnpackedWarFile" ) ) ) {
                is = servletContext.getResourceAsStream(this.lettersFile);
                if (is == null) {
                    throw new RuntimeException("Unable to load template: servletContext.getResourceAsStream("+ this.lettersFile + ") returns null.");
                }
            } else {
                is = new FileInputStream(servletContext.getRealPath(this.lettersFile));
            }
            
            br = new InputStreamReader(is);
        } catch (FileNotFoundException fnfe) {
            throw new RuntimeException("Unable to load template." + fnfe.getMessage());
        }
        
        if (br == null) {
            throw new RuntimeException("Unable to load template. Unrecognized error.");
        }

        ArrayList letters = new ArrayList();
        BufferedReader bufr = new BufferedReader(br);
        try {
            String line = bufr.readLine();
            while (line != null) {
            	letters.add(line);
                line = bufr.readLine();
            }
        } catch (IOException ioe) {
            throw new RuntimeException("Unable to load template. Unrecognized error.");
        }
        try {
            bufr.close();
        } catch (IOException ioe) {}
        try {
            br.close();
        } catch (IOException ioe) {}
		
		return letters;
	}
	
	public class QuadraticPath {
		private int x1;
		private int y1;
		private int x2;
		private int y2;
		private int x3;
		private int y3;
		
		public int getX1() {
			return x1;
		}


		public void setX1(int x1) {
			this.x1 = x1;
		}


		public int getX2() {
			return x2;
		}


		public void setX2(int x2) {
			this.x2 = x2;
		}


		public int getX3() {
			return x3;
		}


		public void setX3(int x3) {
			this.x3 = x3;
		}


		public int getY1() {
			return y1;
		}


		public void setY1(int y1) {
			this.y1 = y1;
		}


		public int getY2() {
			return y2;
		}


		public void setY2(int y2) {
			this.y2 = y2;
		}


		public int getY3() {
			return y3;
		}


		public void setY3(int y3) {
			this.y3 = y3;
		}


		public QuadraticPath(int x1, int y1, int x2, int y2, int x3, int y3) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.x3 = x3;
			this.y3 = y3;
		}
		public String ToString() {
            return "" + this.x1 + "," + this.y1 + "," + this.x2 + "," + this.y2 + "," + this.x3 + "," + this.y3;
        }
	}
	
	class QuadraticPaths {
        private int maxX;
        private int maxY;
        private int minX;
        private int minY;
        private ArrayList paths;
        private boolean needNewMetrics;
        
        public int getMaxX() {
			return maxX;
		}
		public void setMaxX(int maxX) {
			this.maxX = maxX;
		}
		public int getMaxY() {
			return maxY;
		}
		public void setMaxY(int maxY) {
			this.maxY = maxY;
		}
		public int getMinX() {
			return minX;
		}
		public void setMinX(int minX) {
			this.minX = minX;
		}
		public int getMinY() {
			return minY;
		}
		public void setMinY(int minY) {
			this.minY = minY;
		}
		public QuadraticPaths()
        {
            this.paths = new ArrayList();
            needNewMetrics = true;
        }
        
		
		public void LoadFromString(String str) {
            String[] c = str.split(",");
            for (int i = 1; i < c.length; i += 6)
                this.AddPath(
            		Integer.parseInt(c[i]), 
            		Integer.parseInt(c[i + 1]), 
            		Integer.parseInt(c[i + 2]), 
            		Integer.parseInt(c[i + 3]), 
            		Integer.parseInt(c[i + 4]), 
            		Integer.parseInt(c[i + 5])
                );
        }
        
		public String ToString() {
            int i;
            String result = "";
            for (i = 0; i < this.paths.size(); i++) {
                result += ((QuadraticPath)this.paths.get(i)).ToString() + ",";
            }
            return result.substring(0, result.length() - 1);            
        }
		
        public void AddPath(int x1, int y1, int x2, int y2, int x3, int y3) {
            this.paths.add(new QuadraticPath(x1, y1, x2, y2, x3, y3));

            if (this.needNewMetrics) {
                this.maxX = Math.max(x1, x3);
                this.maxY = Math.max(y1, y3);
                this.minX = Math.min(x1, x3);
                this.minY = Math.min(y1, y3);
                this.needNewMetrics = false;
            } else {
            	this.maxX = Math.max(x1, Math.max(x3, this.maxX));
            	this.maxY = Math.max(y1, Math.max(y3, this.maxY));
            	this.minX = Math.min(x1, Math.min(x3, this.minX));
            	this.minY = Math.min(y1, Math.min(y3, this.minY));
            }
        }
        
        public void AddPaths(QuadraticPaths p) {
            for (int i = 0; i < p.paths.size(); i++) {
            	QuadraticPath quadraticPath = (QuadraticPath) p.paths.get(i);	
            	this.AddPath(
            		quadraticPath.getX1(),
	    			quadraticPath.getY1(),
	    			quadraticPath.getX2(),
	    			quadraticPath.getY2(),
	    			quadraticPath.getX3(),
	    			quadraticPath.getY3()
            	);
            }
        }

        public void Normalize(int mx, int my) {
        	this.needNewMetrics = true;
        	int mix = this.minX, miy = this.minY;
            float kx = mx / ((float)(this.maxX - this.minX));
            float ky = my / ((float)(this.maxY - this.minY));
            
            if (mx == 0) {
                kx = ky;
            }
            if (my == 0) {
                ky = kx;
            }
            
            for (int i = 0; i < this.paths.size(); i++) {
            	QuadraticPath quadraticPath = (QuadraticPath) this.paths.get(i);	
            	
            	quadraticPath.setX1((int)((quadraticPath.getX1() - mix) * kx));
            	quadraticPath.setY1((int)((quadraticPath.getY1() - miy) * ky));
            	quadraticPath.setX2((int)((quadraticPath.getX2() - mix) * kx));
            	quadraticPath.setY2((int)((quadraticPath.getY2() - miy) * ky));
            	quadraticPath.setX3((int)((quadraticPath.getX3() - mix) * kx));
            	quadraticPath.setY3((int)((quadraticPath.getY3() - miy) * ky));

                if (this.needNewMetrics) {
                    this.setMaxX(Math.max(quadraticPath.getX1(), quadraticPath.getX3()));
                    this.setMaxY(Math.max(quadraticPath.getY1(), quadraticPath.getY3()));
                    this.setMinX(Math.min(quadraticPath.getX1(), quadraticPath.getX3()));
                    this.setMinY(Math.min(quadraticPath.getY1(), quadraticPath.getY3()));
                    this.needNewMetrics = false;
                } else {
                	this.setMaxX(Math.max(quadraticPath.getX1(), Math.max(quadraticPath.getX3(), this.getMaxX())));
                	this.setMaxY(Math.max(quadraticPath.getY1(), Math.max(quadraticPath.getY3(), this.getMaxY())));
                	this.setMinX(Math.min(quadraticPath.getX1(), Math.min(quadraticPath.getX3(), this.getMinX())));
                	this.setMinY(Math.min(quadraticPath.getY1(), Math.min(quadraticPath.getY3(), this.getMinY())));
                }
            }
        }
        
        public void Multiply(int mx, int my) {
            int t, i;
            for (i = 0; i < this.paths.size(); i++){
            	QuadraticPath quadraticPath = (QuadraticPath) this.paths.get(i);
                quadraticPath.setX1(quadraticPath.getX1() * mx);
                quadraticPath.setY1(quadraticPath.getY1() * my);
                quadraticPath.setX2(quadraticPath.getX2() * mx);
                quadraticPath.setY2(quadraticPath.getY2() * my);
                quadraticPath.setX3(quadraticPath.getX3() * mx);
                quadraticPath.setY3(quadraticPath.getY3() * my);
            }
            
            this.maxX = this.maxX * mx;
            this.maxY = this.maxY * my;
            this.minX = this.minX * mx;
            this.minY = this.minY * my;
            
            if (this.maxX < this.minX) {
                t = this.maxX;
                this.maxX = this.minX;
                this.minX = t;
            }
            if (this.maxY < this.minY) {
                t = this.maxY;
                this.maxY = this.minY;
                this.minY = t;
            }
        }
        
        public void Rotate(int deg) {
            this.needNewMetrics = true;
            double ang = deg * Math.PI / 180;
            double angSin = Math.sin(ang), angCos = Math.cos(ang);
            int i, tx, ty;
            
            for (i = 0; i < this.paths.size(); i++) {
            	QuadraticPath quadraticPath = (QuadraticPath) this.paths.get(i);
            	
                tx = (int)(quadraticPath.getX1() * angCos - quadraticPath.getY1() * angSin);
                ty = (int)(quadraticPath.getX1() * angSin + quadraticPath.getY1() * angCos);
                quadraticPath.setX1(tx);
                quadraticPath.setY1(ty);
                tx = (int)(quadraticPath.getX2() * angCos - quadraticPath.getY2() * angSin);
                ty = (int)(quadraticPath.getX2() * angSin + quadraticPath.getY2() * angCos);
                quadraticPath.setX2(tx);
                quadraticPath.setY2(ty);
                tx = (int)(quadraticPath.getX3() * angCos - quadraticPath.getY3() * angSin);
                ty = (int)(quadraticPath.getX3() * angSin + quadraticPath.getY3() * angCos);
                quadraticPath.setX3(tx);
                quadraticPath.setY3(ty);

                if (this.needNewMetrics) {
                    this.setMaxX(Math.max(quadraticPath.getX1(), quadraticPath.getX3()));
                    this.setMaxY(Math.max(quadraticPath.getY1(), quadraticPath.getY3()));
                    this.setMinX(Math.min(quadraticPath.getX1(), quadraticPath.getX3()));
                    this.setMinY(Math.min(quadraticPath.getY1(), quadraticPath.getY3()));
                    this.needNewMetrics = false;
                } else {
                	this.setMaxX(Math.max(quadraticPath.getX1(), Math.max(quadraticPath.getX3(), this.getMaxX())));
                	this.setMaxY(Math.max(quadraticPath.getY1(), Math.max(quadraticPath.getY3(), this.getMaxY())));
                	this.setMinX(Math.min(quadraticPath.getX1(), Math.min(quadraticPath.getX3(), this.getMinX())));
                	this.setMinY(Math.min(quadraticPath.getY1(), Math.min(quadraticPath.getY3(), this.getMinY())));
                }
            }
        }
        
        public void Wave(double w)
        {
            int i;
            double dx = (this.maxX - this.minX) * w;
            double dy = (this.maxY - this.minY) / 1;
            double omega = this.minX;
            this.needNewMetrics = false;
            
            for (i = 0; i < this.paths.size(); i++) {
            	QuadraticPath quadraticPath = (QuadraticPath) this.paths.get(i);
            	
            	quadraticPath.setX1( quadraticPath.getX1() + (int)(dx * Math.cos(Math.PI * (quadraticPath.getY1() - omega) / dy)));
            	quadraticPath.setX2( quadraticPath.getX2() + (int)(dx * Math.cos(Math.PI * (quadraticPath.getY2() - omega) / dy)));
            	quadraticPath.setX3( quadraticPath.getX3() + (int)(dx * Math.cos(Math.PI * (quadraticPath.getY3() - omega) / dy)));
                
                if (this.needNewMetrics) {
                    this.setMaxX(Math.max(quadraticPath.getX1(), quadraticPath.getX3()));
                    this.setMaxY(Math.max(quadraticPath.getY1(), quadraticPath.getY3()));
                    this.setMinX(Math.min(quadraticPath.getX1(), quadraticPath.getX3()));
                    this.setMinY(Math.min(quadraticPath.getY1(), quadraticPath.getY3()));
                    this.needNewMetrics = false;
                } else {
                	this.setMaxX(Math.max(quadraticPath.getX1(), Math.max(quadraticPath.getX3(), this.getMaxX())));
                	this.setMaxY(Math.max(quadraticPath.getY1(), Math.max(quadraticPath.getY3(), this.getMaxY())));
                	this.setMinX(Math.min(quadraticPath.getX1(), Math.min(quadraticPath.getX3(), this.getMinX())));
                	this.setMinY(Math.min(quadraticPath.getY1(), Math.min(quadraticPath.getY3(), this.getMinY())));
                }
            }
        }
        
        public void Addition(int cx, int cy) {
            for (int i = 0; i < paths.size(); i++) {
            	QuadraticPath quadraticPath = (QuadraticPath) this.paths.get(i);
            
	        	quadraticPath.setX1(quadraticPath.getX1() + cx);
	        	quadraticPath.setY1(quadraticPath.getY1() + cy);
	        	quadraticPath.setX2(quadraticPath.getX2() + cx);
	        	quadraticPath.setY2(quadraticPath.getY2() + cy);
	        	quadraticPath.setX3(quadraticPath.getX3() + cx);
	        	quadraticPath.setY3(quadraticPath.getY3() + cy);
            }
            this.maxX += cx;
            this.maxY += cy;
            this.minX += cx;
            this.minY += cy;
        }
        
        public void Broke(int dx, int dy) {
            this.needNewMetrics = true;
            int rx, ry, i;
            for (i = 0; i < this.paths.size(); i++) {
            	QuadraticPath quadraticPath = (QuadraticPath) this.paths.get(i);
            	
                rx = Captcha.getRandomInt(2*dx) - dx;
                ry = Captcha.getRandomInt(2*dy) - dy;
                quadraticPath.setX1(quadraticPath.getX1() + rx);
                quadraticPath.setY1(quadraticPath.getY1() + ry);
                rx = Captcha.getRandomInt(2*dx) - dx;
                ry = Captcha.getRandomInt(2*dy) - dy;
                quadraticPath.setX3(quadraticPath.getX3() + rx);
                quadraticPath.setY3(quadraticPath.getY3() + ry);

                if (this.needNewMetrics) {
                    this.setMaxX(Math.max(quadraticPath.getX1(), quadraticPath.getX3()));
                    this.setMaxY(Math.max(quadraticPath.getY1(), quadraticPath.getY3()));
                    this.setMinX(Math.min(quadraticPath.getX1(), quadraticPath.getX3()));
                    this.setMinY(Math.min(quadraticPath.getY1(), quadraticPath.getY3()));
                    this.needNewMetrics = false;
                } else {
                	this.setMaxX(Math.max(quadraticPath.getX1(), Math.max(quadraticPath.getX3(), this.getMaxX())));
                	this.setMaxY(Math.max(quadraticPath.getY1(), Math.max(quadraticPath.getY3(), this.getMaxY())));
                	this.setMinX(Math.min(quadraticPath.getX1(), Math.min(quadraticPath.getX3(), this.getMinX())));
                	this.setMinY(Math.min(quadraticPath.getY1(), Math.min(quadraticPath.getY3(), this.getMinY())));
                }
            }
        }
        
        public void Noises(int n) {
            
            int x1, y1, x2, y2, x3, y3;
            for (int i = 0; i < n; i++) {
                x1 = minX + Captcha.getRandomInt(maxX - minX);
                y1 = minY + Captcha.getRandomInt(maxY - minY);
                x3 = minX + Captcha.getRandomInt(maxX - minX);
                y3 = minY + Captcha.getRandomInt(maxY - minY);
                x2 = Math.min(x1, x3) + Captcha.getRandomInt(Math.max(x1, x3) - Math.min(x1, x3));
                y2 = Math.min(y1, y3) + Captcha.getRandomInt(Math.max(y1, y3) - Math.min(y1, y3));
                this.AddPath(x1, y1, x2, y2, x3, y3);
            }
        }
        
        public void Mix() {
            int i, j;
            for (i = 0; i < this.paths.size(); i++) {
            	j = Captcha.getRandomInt(this.paths.size());
            	QuadraticPath tempQuadraticPath = (QuadraticPath) this.paths.get(i);
            	this.paths.set(i, this.paths.get(j));
            	this.paths.set(j, tempQuadraticPath);
            }
        }
    }
}



//End Captcha component

