/*
MySQL Data Transfer
Source Host: localhost
Source Database: supremaimoveis
Target Host: localhost
Target Database: supremaimoveis
Date: 16/10/2010 15:28:30
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tbl_cidade
-- ----------------------------
CREATE TABLE `tbl_cidade` (
  `Cod_Cidade` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(40) NOT NULL,
  `Cod_Estado` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Cidade`),
  KEY `FK_tbl_cidade_tbl_estado_Cod_Estado` (`Cod_Estado`),
  CONSTRAINT `FK_tbl_cidade_tbl_estado_Cod_Estado` FOREIGN KEY (`Cod_Estado`) REFERENCES `tbl_estado` (`Cod_Estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_clausula
-- ----------------------------
CREATE TABLE `tbl_clausula` (
  `Cod_Clausula` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo` int(11) NOT NULL,
  `Descricao` varchar(655) DEFAULT NULL,
  `tbl_contrato_Cod_Contrato` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Clausula`),
  KEY `FK_tbl_clausula_tbl_tipo_causula_Cod_Tipo` (`Tipo`),
  KEY `tbl_contrato_Cod_Contrato` (`tbl_contrato_Cod_Contrato`),
  CONSTRAINT `tbl_clausula_ibfk_1` FOREIGN KEY (`tbl_contrato_Cod_Contrato`) REFERENCES `tbl_contrato` (`Cod_Contrato`),
  CONSTRAINT `FK_tbl_clausula_tbl_tipo_causula_Cod_Tipo` FOREIGN KEY (`Tipo`) REFERENCES `tbl_tipo_causula` (`Cod_Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_cliente
-- ----------------------------
CREATE TABLE `tbl_cliente` (
  `Cod_Cliente` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(40) NOT NULL,
  `Data_Nasc` date NOT NULL,
  `Nome_U` varchar(16) NOT NULL,
  `Senha_U` varchar(40) NOT NULL,
  `Nacionalidade` varchar(30) NOT NULL,
  `Endereco` varchar(200) NOT NULL,
  `Tel_Fixo` int(11) DEFAULT NULL,
  `Tel_Cel` int(11) DEFAULT NULL,
  `Tel_Comercial` int(11) DEFAULT NULL,
  `Cod_Estado` int(11) DEFAULT NULL,
  `Cod_Cidade` int(11) DEFAULT NULL,
  `Cod_Funcionario` int(11) DEFAULT NULL,
  `Orgao_Emissor` int(11) DEFAULT NULL,
  `Tipo_Cliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Cliente`),
  KEY `Cod_Estado` (`Cod_Estado`),
  KEY `Tipo_Cliente` (`Tipo_Cliente`),
  KEY `Cod_Cidade` (`Cod_Cidade`),
  KEY `Cod_Funcionario` (`Cod_Funcionario`),
  KEY `Orgao_Emissor` (`Orgao_Emissor`),
  CONSTRAINT `tbl_cliente_ibfk_5` FOREIGN KEY (`Orgao_Emissor`) REFERENCES `tbl_orgaoemissor` (`Cod_Orgao`),
  CONSTRAINT `tbl_cliente_ibfk_1` FOREIGN KEY (`Cod_Estado`) REFERENCES `tbl_estado` (`Cod_Estado`),
  CONSTRAINT `tbl_cliente_ibfk_2` FOREIGN KEY (`Tipo_Cliente`) REFERENCES `tbl_tipo_cliente` (`Cod_Tipo_Cliente`),
  CONSTRAINT `tbl_cliente_ibfk_3` FOREIGN KEY (`Cod_Cidade`) REFERENCES `tbl_cidade` (`Cod_Cidade`),
  CONSTRAINT `tbl_cliente_ibfk_4` FOREIGN KEY (`Cod_Funcionario`) REFERENCES `tbl_funcionario` (`Cod_Funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=16384 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_contrato
-- ----------------------------
CREATE TABLE `tbl_contrato` (
  `Cod_Contrato` int(11) NOT NULL AUTO_INCREMENT,
  `tbl_funcionario_Cod_Funcionario` int(11) DEFAULT NULL,
  `tbl_cliente_Cod_Cliente` int(11) DEFAULT NULL,
  `tbl_imovel_Cod_Imovel` int(11) DEFAULT NULL,
  `tbl_fiador_Cod_Fiador` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Contrato`),
  KEY `tbl_funcionario_Cod_Funcionario` (`tbl_funcionario_Cod_Funcionario`),
  KEY `tbl_cliente_Cod_Cliente` (`tbl_cliente_Cod_Cliente`),
  KEY `tbl_imovel_Cod_Imovel` (`tbl_imovel_Cod_Imovel`),
  KEY `tbl_fiador_Cod_Fiador` (`tbl_fiador_Cod_Fiador`),
  CONSTRAINT `tbl_contrato_ibfk_4` FOREIGN KEY (`tbl_fiador_Cod_Fiador`) REFERENCES `tbl_fiador` (`Cod_Fiador`),
  CONSTRAINT `tbl_contrato_ibfk_1` FOREIGN KEY (`tbl_funcionario_Cod_Funcionario`) REFERENCES `tbl_funcionario` (`Cod_Funcionario`),
  CONSTRAINT `tbl_contrato_ibfk_2` FOREIGN KEY (`tbl_cliente_Cod_Cliente`) REFERENCES `tbl_cliente` (`Cod_Cliente`),
  CONSTRAINT `tbl_contrato_ibfk_3` FOREIGN KEY (`tbl_imovel_Cod_Imovel`) REFERENCES `tbl_imovel` (`Cod_Imovel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_destinacao
-- ----------------------------
CREATE TABLE `tbl_destinacao` (
  `Cod_destinacao` int(11) NOT NULL,
  `Destinacao` varchar(20) NOT NULL,
  PRIMARY KEY (`Cod_destinacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_documentacao
-- ----------------------------
CREATE TABLE `tbl_documentacao` (
  `Cod_Doc` int(11) NOT NULL,
  `Anexo` blob,
  `Tipo_Doc` int(11) DEFAULT NULL,
  `Cod_Cliente` int(11) DEFAULT NULL,
  `Cod_Fiador` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Doc`),
  KEY `Tipo_Doc` (`Tipo_Doc`),
  KEY `Cod_Cliente` (`Cod_Cliente`),
  KEY `Cod_Fiador` (`Cod_Fiador`),
  CONSTRAINT `tbl_documentacao_ibfk_3` FOREIGN KEY (`Cod_Fiador`) REFERENCES `tbl_fiador` (`Cod_Fiador`),
  CONSTRAINT `tbl_documentacao_ibfk_1` FOREIGN KEY (`Tipo_Doc`) REFERENCES `tbl_tipo_doc` (`Cod_Doc`),
  CONSTRAINT `tbl_documentacao_ibfk_2` FOREIGN KEY (`Cod_Cliente`) REFERENCES `tbl_cliente` (`Cod_Cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_estado
-- ----------------------------
CREATE TABLE `tbl_estado` (
  `Cod_Estado` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(40) NOT NULL,
  `UF` varchar(40) NOT NULL,
  PRIMARY KEY (`Cod_Estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_fiador
-- ----------------------------
CREATE TABLE `tbl_fiador` (
  `Cod_Fiador` int(11) NOT NULL AUTO_INCREMENT,
  `tbl_orgaoemissor_Cod_Orgao` int(11) DEFAULT NULL,
  `tbl_estado_Cod_Estado` int(11) DEFAULT NULL,
  `tbl_cidade_Cod_Cidade` int(11) DEFAULT NULL,
  `tbl_cliente_Cod_Cliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Fiador`),
  KEY `tbl_estado_Cod_Estado` (`tbl_estado_Cod_Estado`),
  KEY `tbl_cidade_Cod_Cidade` (`tbl_cidade_Cod_Cidade`),
  KEY `tbl_cliente_Cod_Cliente` (`tbl_cliente_Cod_Cliente`),
  KEY `tbl_orgaoemissor_Cod_Orgao` (`tbl_orgaoemissor_Cod_Orgao`),
  CONSTRAINT `tbl_fiador_ibfk_4` FOREIGN KEY (`tbl_orgaoemissor_Cod_Orgao`) REFERENCES `tbl_orgaoemissor` (`Cod_Orgao`),
  CONSTRAINT `tbl_fiador_ibfk_1` FOREIGN KEY (`tbl_estado_Cod_Estado`) REFERENCES `tbl_estado` (`Cod_Estado`),
  CONSTRAINT `tbl_fiador_ibfk_2` FOREIGN KEY (`tbl_cidade_Cod_Cidade`) REFERENCES `tbl_cidade` (`Cod_Cidade`),
  CONSTRAINT `tbl_fiador_ibfk_3` FOREIGN KEY (`tbl_cliente_Cod_Cliente`) REFERENCES `tbl_cliente` (`Cod_Cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_funcionario
-- ----------------------------
CREATE TABLE `tbl_funcionario` (
  `Cod_Funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(40) NOT NULL,
  `tbl_cidade_Cod_Cidade` int(11) DEFAULT NULL,
  `tbl_estado_Cod_Estado` int(11) DEFAULT NULL,
  `tbl_orgaoemissor_Cod_Orgao` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Funcionario`),
  KEY `tbl_cidade_Cod_Cidade` (`tbl_cidade_Cod_Cidade`),
  KEY `tbl_estado_Cod_Estado` (`tbl_estado_Cod_Estado`),
  KEY `tbl_orgaoemissor_Cod_Orgao` (`tbl_orgaoemissor_Cod_Orgao`),
  CONSTRAINT `tbl_funcionario_ibfk_3` FOREIGN KEY (`tbl_orgaoemissor_Cod_Orgao`) REFERENCES `tbl_orgaoemissor` (`Cod_Orgao`),
  CONSTRAINT `tbl_funcionario_ibfk_1` FOREIGN KEY (`tbl_cidade_Cod_Cidade`) REFERENCES `tbl_cidade` (`Cod_Cidade`),
  CONSTRAINT `tbl_funcionario_ibfk_2` FOREIGN KEY (`tbl_estado_Cod_Estado`) REFERENCES `tbl_estado` (`Cod_Estado`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=16384 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_imovel
-- ----------------------------
CREATE TABLE `tbl_imovel` (
  `Cod_Imovel` int(11) NOT NULL AUTO_INCREMENT,
  `tbl_cliente_Cod_Cliente` int(11) DEFAULT NULL,
  `tbl_funcionario_Cod_Funcionario` int(11) DEFAULT NULL,
  `tbl_situacao_Cod_Situacao` int(11) DEFAULT NULL,
  `tbl_destinacao_Cod_destinacao` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Imovel`),
  KEY `tbl_cliente_Cod_Cliente` (`tbl_cliente_Cod_Cliente`),
  KEY `tbl_funcionario_Cod_Funcionario` (`tbl_funcionario_Cod_Funcionario`),
  KEY `tbl_situacao_Cod_Situacao` (`tbl_situacao_Cod_Situacao`),
  KEY `tbl_destinacao_Cod_destinacao` (`tbl_destinacao_Cod_destinacao`),
  CONSTRAINT `tbl_imovel_ibfk_4` FOREIGN KEY (`tbl_destinacao_Cod_destinacao`) REFERENCES `tbl_destinacao` (`Cod_destinacao`),
  CONSTRAINT `tbl_imovel_ibfk_1` FOREIGN KEY (`tbl_cliente_Cod_Cliente`) REFERENCES `tbl_cliente` (`Cod_Cliente`),
  CONSTRAINT `tbl_imovel_ibfk_2` FOREIGN KEY (`tbl_funcionario_Cod_Funcionario`) REFERENCES `tbl_funcionario` (`Cod_Funcionario`),
  CONSTRAINT `tbl_imovel_ibfk_3` FOREIGN KEY (`tbl_situacao_Cod_Situacao`) REFERENCES `tbl_situacao` (`Cod_Situacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_orgaoemissor
-- ----------------------------
CREATE TABLE `tbl_orgaoemissor` (
  `Cod_Orgao` int(11) NOT NULL AUTO_INCREMENT,
  `Sigla` varchar(5) NOT NULL,
  `Descricao` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Cod_Orgao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_preferencia
-- ----------------------------
CREATE TABLE `tbl_preferencia` (
  `Cod_Preferencia` int(11) NOT NULL AUTO_INCREMENT,
  `Cod_Cliente` int(11) NOT NULL,
  `Descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Cod_Preferencia`),
  KEY `FK_tbl_preferencia` (`Cod_Cliente`),
  CONSTRAINT `FK_tbl_preferencia` FOREIGN KEY (`Cod_Cliente`) REFERENCES `tbl_cliente` (`Cod_Cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_situacao
-- ----------------------------
CREATE TABLE `tbl_situacao` (
  `Cod_Situacao` int(11) NOT NULL,
  `Situacao` varchar(20) NOT NULL,
  PRIMARY KEY (`Cod_Situacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_solicitacoes
-- ----------------------------
CREATE TABLE `tbl_solicitacoes` (
  `Cod_Solicitacoes` int(11) NOT NULL AUTO_INCREMENT,
  `Operacao` varchar(255) DEFAULT NULL,
  `Descricao` varchar(255) DEFAULT NULL,
  `tbl_funcionario_Cod_Funcionario` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Solicitacoes`),
  KEY `tbl_funcionario_Cod_Funcionario` (`tbl_funcionario_Cod_Funcionario`),
  CONSTRAINT `tbl_solicitacoes_ibfk_1` FOREIGN KEY (`tbl_funcionario_Cod_Funcionario`) REFERENCES `tbl_funcionario` (`Cod_Funcionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_tipo_causula
-- ----------------------------
CREATE TABLE `tbl_tipo_causula` (
  `Cod_Tipo` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(40) NOT NULL,
  PRIMARY KEY (`Cod_Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_tipo_cliente
-- ----------------------------
CREATE TABLE `tbl_tipo_cliente` (
  `Cod_Tipo_Cliente` int(11) NOT NULL,
  `Descricao` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Cod_Tipo_Cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_tipo_doc
-- ----------------------------
CREATE TABLE `tbl_tipo_doc` (
  `Cod_Doc` int(11) NOT NULL,
  `Descricao` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Cod_Doc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tlb_aluguel
-- ----------------------------
CREATE TABLE `tlb_aluguel` (
  `Cod_Aluguel` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Cod_Aluguel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records 
-- ----------------------------
