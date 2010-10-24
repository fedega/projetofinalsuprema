/*
MySQL Data Transfer
Source Host: localhost
Source Database: supremaimoveis
Target Host: localhost
Target Database: supremaimoveis
Date: 24/10/2010 14:15:44
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tbl_aluguel
-- ----------------------------
CREATE TABLE `tbl_aluguel` (
  `Cod_Aluguel` int(11) NOT NULL,
  `Data` date DEFAULT NULL,
  `Cod_Imovel` int(11) DEFAULT NULL,
  `Cod_Cliente` int(11) DEFAULT NULL,
  `Cod_Fiador` int(11) DEFAULT NULL,
  `Cod_Funcionario` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Aluguel`),
  KEY `Cod_Imovel` (`Cod_Imovel`),
  KEY `Cod_Cliente` (`Cod_Cliente`),
  KEY `Cod_Fiador` (`Cod_Fiador`),
  KEY `Cod_Funcionario` (`Cod_Funcionario`),
  CONSTRAINT `tbl_aluguel_ibfk_4` FOREIGN KEY (`Cod_Funcionario`) REFERENCES `tbl_funcionario` (`Cod_Funcionario`),
  CONSTRAINT `tbl_aluguel_ibfk_1` FOREIGN KEY (`Cod_Imovel`) REFERENCES `tbl_imovel` (`Cod_Imovel`),
  CONSTRAINT `tbl_aluguel_ibfk_2` FOREIGN KEY (`Cod_Cliente`) REFERENCES `tbl_cliente` (`Cod_Cliente`),
  CONSTRAINT `tbl_aluguel_ibfk_3` FOREIGN KEY (`Cod_Fiador`) REFERENCES `tbl_fiador` (`Cod_Fiador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `Cod_Contrato` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Clausula`),
  KEY `FK_tbl_clausula_tbl_tipo_causula_Cod_Tipo` (`Tipo`),
  KEY `Cod_Contrato` (`Cod_Contrato`),
  CONSTRAINT `tbl_clausula_ibfk_1` FOREIGN KEY (`Cod_Contrato`) REFERENCES `tbl_contrato` (`Cod_Contrato`),
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
  `Cod_Funcionario` int(11) DEFAULT NULL,
  `Cod_Cliente` int(11) DEFAULT NULL,
  `Cod_Imovel` int(11) DEFAULT NULL,
  `Cod_Fiador` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Contrato`),
  KEY `Cod_Funcionario` (`Cod_Funcionario`),
  KEY `Cod_Cliente` (`Cod_Cliente`),
  KEY `Cod_Imovel` (`Cod_Imovel`),
  KEY `Cod_Fiador` (`Cod_Fiador`),
  CONSTRAINT `tbl_contrato_ibfk_4` FOREIGN KEY (`Cod_Fiador`) REFERENCES `tbl_fiador` (`Cod_Fiador`),
  CONSTRAINT `tbl_contrato_ibfk_1` FOREIGN KEY (`Cod_Funcionario`) REFERENCES `tbl_funcionario` (`Cod_Funcionario`),
  CONSTRAINT `tbl_contrato_ibfk_2` FOREIGN KEY (`Cod_Cliente`) REFERENCES `tbl_cliente` (`Cod_Cliente`),
  CONSTRAINT `tbl_contrato_ibfk_3` FOREIGN KEY (`Cod_Imovel`) REFERENCES `tbl_imovel` (`Cod_Imovel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_despesas
-- ----------------------------
CREATE TABLE `tbl_despesas` (
  `Cod_Despesas` int(11) NOT NULL,
  `Data` varchar(20) DEFAULT NULL,
  `Valor` int(11) NOT NULL,
  `Tipo_Despesas` int(11) DEFAULT NULL,
  `Cod_Aluguel` int(11) NOT NULL,
  `tbl_situacao_Cod_Situacao` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Despesas`),
  KEY `Cod_Aluguel` (`Cod_Aluguel`),
  KEY `Tipo_Despesas` (`Tipo_Despesas`),
  KEY `tbl_situacao_Cod_Situacao` (`tbl_situacao_Cod_Situacao`),
  CONSTRAINT `tbl_despesas_ibfk_3` FOREIGN KEY (`tbl_situacao_Cod_Situacao`) REFERENCES `tbl_situacao` (`Cod_Situacao`),
  CONSTRAINT `tbl_despesas_ibfk_1` FOREIGN KEY (`Cod_Aluguel`) REFERENCES `tbl_aluguel` (`Cod_Aluguel`),
  CONSTRAINT `tbl_despesas_ibfk_2` FOREIGN KEY (`Tipo_Despesas`) REFERENCES `tbl_tipo_despesas` (`Cod_Despesa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbl_destinacao
-- ----------------------------
CREATE TABLE `tbl_destinacao` (
  `Cod_destinacao` int(11) NOT NULL,
  `Destinacao` varchar(20) NOT NULL,
  PRIMARY KEY (`Cod_destinacao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `Cod_Orgao` int(11) DEFAULT NULL,
  `Cod_Estado` int(11) DEFAULT NULL,
  `Cod_Cidade` int(11) DEFAULT NULL,
  `Cod_Cliente` int(11) DEFAULT NULL,
  `Nome` varchar(40) NOT NULL,
  `Data_Nasc` date NOT NULL,
  `Nome_U` varchar(16) NOT NULL,
  `Senha_U` varchar(40) NOT NULL,
  `Nacionalidaade` varchar(30) NOT NULL,
  `Endereco` varchar(200) NOT NULL,
  `Tel_Fixo` int(11) DEFAULT NULL,
  `Tel_Cel` int(11) DEFAULT NULL,
  `Tel_Comercial` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Fiador`),
  KEY `Cod_Estado` (`Cod_Estado`),
  KEY `Cod_Cidade` (`Cod_Cidade`),
  KEY `Cod_Cliente` (`Cod_Cliente`),
  KEY `Cod_Orgao` (`Cod_Orgao`),
  CONSTRAINT `tbl_fiador_ibfk_4` FOREIGN KEY (`Cod_Orgao`) REFERENCES `tbl_orgaoemissor` (`Cod_Orgao`),
  CONSTRAINT `tbl_fiador_ibfk_1` FOREIGN KEY (`Cod_Estado`) REFERENCES `tbl_estado` (`Cod_Estado`),
  CONSTRAINT `tbl_fiador_ibfk_2` FOREIGN KEY (`Cod_Cidade`) REFERENCES `tbl_cidade` (`Cod_Cidade`),
  CONSTRAINT `tbl_fiador_ibfk_3` FOREIGN KEY (`Cod_Cliente`) REFERENCES `tbl_cliente` (`Cod_Cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_funcionario
-- ----------------------------
CREATE TABLE `tbl_funcionario` (
  `Cod_Funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(40) NOT NULL,
  `Cod_Cidade` int(11) DEFAULT NULL,
  `Cod_Estado` int(11) DEFAULT NULL,
  `Cod_Orgao` int(11) DEFAULT NULL,
  `Nome_U` varchar(20) NOT NULL,
  `Senha_U` varchar(20) NOT NULL,
  `Endereco` varchar(40) DEFAULT NULL,
  `Tel_Fixo` int(11) DEFAULT NULL,
  `Tel_Cel` int(11) DEFAULT NULL,
  `CPF` int(11) DEFAULT NULL,
  `Data_Nasc` date DEFAULT NULL,
  `CRECI` int(11) DEFAULT NULL,
  `Nivel_Controle` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Funcionario`),
  KEY `Cod_Cidade` (`Cod_Cidade`),
  KEY `Cod_Estado` (`Cod_Estado`),
  KEY `Cod_Orgao` (`Cod_Orgao`),
  CONSTRAINT `tbl_funcionario_ibfk_3` FOREIGN KEY (`Cod_Orgao`) REFERENCES `tbl_orgaoemissor` (`Cod_Orgao`),
  CONSTRAINT `tbl_funcionario_ibfk_1` FOREIGN KEY (`Cod_Cidade`) REFERENCES `tbl_cidade` (`Cod_Cidade`),
  CONSTRAINT `tbl_funcionario_ibfk_2` FOREIGN KEY (`Cod_Estado`) REFERENCES `tbl_estado` (`Cod_Estado`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=16384 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tbl_imovel
-- ----------------------------
CREATE TABLE `tbl_imovel` (
  `Cod_Imovel` int(11) NOT NULL AUTO_INCREMENT,
  `Cod_Cliente` int(11) DEFAULT NULL,
  `Cod_Funcionario` int(11) DEFAULT NULL,
  `Cod_Situacao` int(11) DEFAULT NULL,
  `Cod_destinacao` int(11) DEFAULT NULL,
  `Endereco` varchar(40) DEFAULT NULL,
  `CEP` int(11) DEFAULT NULL,
  `Bairro` varchar(20) DEFAULT NULL,
  `Cod_Estado` int(11) DEFAULT NULL,
  `Cod_Cidade` int(11) DEFAULT NULL,
  `N_Quartos` int(11) DEFAULT NULL,
  `N_Suites` int(11) DEFAULT NULL,
  `N_Banheiros` int(11) DEFAULT NULL,
  `N_Salas` int(11) DEFAULT NULL,
  `N_Cozinhas` int(11) DEFAULT NULL,
  `Dep_Empregada` bit(1) DEFAULT NULL,
  `Garagem` bit(1) DEFAULT NULL,
  `Mts_Quadrados` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Imovel`),
  KEY `Cod_Cliente` (`Cod_Cliente`),
  KEY `Cod_Funcionario` (`Cod_Funcionario`),
  KEY `Cod_Situacao` (`Cod_Situacao`),
  KEY `Cod_destinacao` (`Cod_destinacao`),
  KEY `Cod_Estado` (`Cod_Estado`),
  KEY `Cod_Cidade` (`Cod_Cidade`),
  CONSTRAINT `tbl_imovel_ibfk_6` FOREIGN KEY (`Cod_Cidade`) REFERENCES `tbl_cidade` (`Cod_Cidade`),
  CONSTRAINT `tbl_imovel_ibfk_1` FOREIGN KEY (`Cod_Cliente`) REFERENCES `tbl_cliente` (`Cod_Cliente`),
  CONSTRAINT `tbl_imovel_ibfk_2` FOREIGN KEY (`Cod_Funcionario`) REFERENCES `tbl_funcionario` (`Cod_Funcionario`),
  CONSTRAINT `tbl_imovel_ibfk_3` FOREIGN KEY (`Cod_Situacao`) REFERENCES `tbl_situacao` (`Cod_Situacao`),
  CONSTRAINT `tbl_imovel_ibfk_4` FOREIGN KEY (`Cod_destinacao`) REFERENCES `tbl_destinacao` (`Cod_destinacao`),
  CONSTRAINT `tbl_imovel_ibfk_5` FOREIGN KEY (`Cod_Estado`) REFERENCES `tbl_estado` (`Cod_Estado`)
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbl_solicitacoes
-- ----------------------------
CREATE TABLE `tbl_solicitacoes` (
  `Cod_Solicitacoes` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(255) DEFAULT NULL,
  `Cod_Funcionario` int(11) DEFAULT NULL,
  `Tipo_Solicitacao` int(11) DEFAULT NULL,
  `Cod_Situacao` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Solicitacoes`),
  KEY `Cod_Funcionario` (`Cod_Funcionario`),
  KEY `Tipo_Solicitacao` (`Tipo_Solicitacao`),
  KEY `Cod_Situacao` (`Cod_Situacao`),
  CONSTRAINT `tbl_solicitacoes_ibfk_3` FOREIGN KEY (`Cod_Situacao`) REFERENCES `tbl_situacao` (`Cod_Situacao`),
  CONSTRAINT `tbl_solicitacoes_ibfk_1` FOREIGN KEY (`Cod_Funcionario`) REFERENCES `tbl_funcionario` (`Cod_Funcionario`),
  CONSTRAINT `tbl_solicitacoes_ibfk_2` FOREIGN KEY (`Tipo_Solicitacao`) REFERENCES `tbl_tipo_solicitacao` (`Cod_Solicitacao`)
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbl_tipo_despesas
-- ----------------------------
CREATE TABLE `tbl_tipo_despesas` (
  `Cod_Despesa` int(11) NOT NULL,
  `Descricao` varchar(20) NOT NULL,
  PRIMARY KEY (`Cod_Despesa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbl_tipo_doc
-- ----------------------------
CREATE TABLE `tbl_tipo_doc` (
  `Cod_Doc` int(11) NOT NULL,
  `Descricao` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Cod_Doc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbl_tipo_solicitacao
-- ----------------------------
CREATE TABLE `tbl_tipo_solicitacao` (
  `Cod_Solicitacao` int(11) NOT NULL,
  `Descricao` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Cod_Solicitacao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbl_venda
-- ----------------------------
CREATE TABLE `tbl_venda` (
  `Cod_Venda` int(11) NOT NULL,
  `Data` varchar(20) DEFAULT NULL,
  `Cod_Imovel` int(11) DEFAULT NULL,
  `Cod_Funcionario` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Venda`),
  KEY `Cod_Imovel` (`Cod_Imovel`),
  KEY `Cod_Funcionario` (`Cod_Funcionario`),
  CONSTRAINT `tbl_venda_ibfk_2` FOREIGN KEY (`Cod_Funcionario`) REFERENCES `tbl_funcionario` (`Cod_Funcionario`),
  CONSTRAINT `tbl_venda_ibfk_1` FOREIGN KEY (`Cod_Imovel`) REFERENCES `tbl_imovel` (`Cod_Imovel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbl_visita
-- ----------------------------
CREATE TABLE `tbl_visita` (
  `Cod_Visita` int(11) NOT NULL,
  `Data` date DEFAULT NULL,
  `Hora` datetime DEFAULT NULL,
  `Cod_Imovel` int(11) DEFAULT NULL,
  `Cod_Funcionario` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Visita`),
  KEY `Cod_Imovel` (`Cod_Imovel`),
  KEY `Cod_Funcionario` (`Cod_Funcionario`),
  CONSTRAINT `tbl_visita_ibfk_2` FOREIGN KEY (`Cod_Funcionario`) REFERENCES `tbl_funcionario` (`Cod_Funcionario`),
  CONSTRAINT `tbl_visita_ibfk_1` FOREIGN KEY (`Cod_Imovel`) REFERENCES `tbl_imovel` (`Cod_Imovel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
