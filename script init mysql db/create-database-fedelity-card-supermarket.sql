-- Creazione del database
CREATE DATABASE IF NOT EXISTS `fedelity_card_supermarket`;

-- Utilizzo del database
USE fedelity_card_supermarket;

-- Creazione della tabella "cliente"
CREATE TABLE IF NOT EXISTS `cliente` (
    `id_cliente` bigint AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(255) NOT NULL,
    `cognome` VARCHAR(255) NOT NULL,
    `indirizzo` VARCHAR(255),
    `numero_di_telefono` VARCHAR(20),
    `email` VARCHAR(255),
    `data_tesseramento` TIMESTAMP,
    `numero_tessera` VARCHAR(20),
    `storici_acquisti` TEXT
);

-- Creazione della tabella "acquisto"
CREATE TABLE IF NOT EXISTS `acquisto` (
    `id_acquisto` bigint AUTO_INCREMENT PRIMARY KEY,
    `id_prodotto` varchar(255) NULL,
    `nome_prodotto` varchar(255) NULL,
    `prezzo_prodotto` decimal(10,2),
    `cliente_id` bigint,
    CONSTRAINT fk_cliente_acquisto
    FOREIGN KEY (cliente_id) REFERENCES cliente(id_cliente)
);

-- Creazione della tabella "sessione_acquisto"
CREATE TABLE IF NOT EXISTS `sessione_acquisto` (
    `id_sessione_acquisto` bigint AUTO_INCREMENT PRIMARY KEY,
    `data_inizio` TIMESTAMP NULL,
    `data_fine` TIMESTAMP NULL,
    `id_cliente` bigint,
    CONSTRAINT fk_cliente_sessione_acquisto
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

-- Creazione della tabella "fedelity_card"
CREATE TABLE IF NOT EXISTS `carta_fedelta` (
    `id_carta_fedelta` bigint AUTO_INCREMENT PRIMARY KEY,
    `numero_tessera` VARCHAR(20) NOT NULL,
    `data_di_creazione_tessera` TIMESTAMP,
    `punti` bigint DEFAULT 0
);

-- Creazione della tabella "points_collection_campaign"
CREATE TABLE IF NOT EXISTS `campagna_punti` (
    `id_campagna_punti` bigint AUTO_INCREMENT PRIMARY KEY,
    `nome_campagna` VARCHAR(255) NOT NULL,
    `data_Inizio` TIMESTAMP,
    `data_fine` TIMESTAMP,
    `conversione_punti_euro` DECIMAL(10, 2)
);

-- Creazione della tabella "type_of_customer"
CREATE TABLE IF NOT EXISTS `tipo_cliente` (
    `id_tipo_cliente` bigint AUTO_INCREMENT PRIMARY KEY,
    `tipo_cliente` VARCHAR(100) NOT NULL,
    `descrizione` varchar(500) null
);

-- creazione della tabella "azienda"
CREATE TABLE IF NOT EXISTS `azienda` (
     `id_azienda` bigint AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(255) NOT NULL,
    `regione` VARCHAR(255) NOT NULL,
    `citta` VARCHAR(255) not null
);

-- creazione della tabella "tipologia_azienda"
CREATE TABLE IF NOT EXISTS `tipologia_azienda` (
    `id_tipologia_azienda` bigint AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(255) NOT NULL,
    `descrizione` VARCHAR(255) NOT NULL -- ,
    -- `punto_vendita_id` bigint , credo sia superfluo
    -- ADD CONSTRAINT fk_punto_vendita 
    -- FOREIGN KEY (punto_vendita_id) REFERENCES punto_vandita(id)
);

-- Creazione della tabella "punto_vedinta"
CREATE TABLE IF NOT EXISTS `punto_vendita`(
    `id_punto_vendita` bigint AUTO_INCREMENT PRIMARY KEY,
    `nome_punto_vendita` VARCHAR(255) NOT NULL,
    `citta` VARCHAR(255) NOT NULL,
    `regione` VARCHAR(255) NOT NULL,
    `azienda_id` bigint,
    `tipologia_azienda_id` bigint,
    CONSTRAINT fk_azienda_punto_vendita
    FOREIGN KEY (azienda_id) REFERENCES azienda(id_azienda),
    CONSTRAINT fk_tipologia_azienda_punto_vendita
    FOREIGN KEY (tipologia_azienda_id) REFERENCES tipologia_azienda(id_tipologia_azienda)
);

-- Creazione della tabella "raccordo_carta_fedelta_punto_vendita" per correlazione manytomany
CREATE TABLE IF NOT EXISTS `raccordo_carta_fedelta_punto_vendita`(
    `id_raccordo_carta_fedelta_punto_vendita` bigint AUTO_INCREMENT PRIMARY KEY,
    `carta_fedelta_racc_id` bigint NOT NULL,
    `punto_vendita_racc_id` bigint NOT NULL,
    PRIMARY KEY(`carta_fedelta_racc_id`, `punto_vendita_racc_id`),
    CONSTRAINT fk_carta_fedelta_racc_id
    FOREIGN KEY (carta_fedelta_racc_id) REFERENCES carta_fedelta(id_carta_fedelta),
    CONSTRAINT fk_punto_vendita_racc_id
    FOREIGN KEY (punto_vendita_racc_id) REFERENCES punto_vedinta(id_punto_vendita)
);

-- add costrain customer (fedelity_card)

ALTER TABLE cliente ADD COLUMN carta_fedelta_id bigint;

ALTER TABLE cliente ADD CONSTRAINT fk_fedelity_card
FOREIGN KEY (carta_fedelta_id) REFERENCES carta_fedelta(id_carta_fedelta);

-- add costrain customer (type_of_customer)

ALTER TABLE cliente ADD COLUMN tipo_cliente_id bigint;

ALTER TABLE cliente ADD CONSTRAINT fk_tipo_cliente
FOREIGN KEY (tipo_cliente_id) REFERENCES tipo_cliente(id_tipo_cliente);

-- add costrain customer (azienda)

ALTER TABLE azienda ADD COLUMN punto_vendita_id bigint;

ALTER TABLE azienda ADD CONSTRAINT fk_punto_vendita_azienda
FOREIGN KEY (punto_vendita_id) REFERENCES punto_vendita(id_punto_vendita);

-- add costrain carta_fedelta

ALTER TABLE carta_fedelta ADD COLUMN punto_vendita_id bigint;

ALTER TABLE carta_fedelta ADD CONSTRAINT fk_tipologia_azienda_carta_fedelta
FOREIGN KEY (punto_vendita_id) REFERENCES punto_vendita(id_punto_vendita);

-- add costrain carta_fedelta
ALTER TABLE carta_fedelta ADD CONSTRAINT fk_punto_vendita_fedelity_card
FOREIGN KEY (punto_vendita_id) REFERENCES punto_vendita(id_punto_vendita);

-- insert into type_of_consumer

INSERT into `tipo_cliente` (`tipo_cliente`)
VALUES ('BUSINESS'), ('CONSUMATORE');
