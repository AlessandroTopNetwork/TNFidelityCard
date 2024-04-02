-- Creazione del database
CREATE DATABASE IF NOT EXISTS `fedelity_card_supermarket`;

-- Utilizzo del database
USE fedelity_card_supermarket;

-- Creazione della tabella "cliente"
CREATE TABLE IF NOT EXISTS `cliente` (
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(255) NOT NULL,
    `cognome` VARCHAR(255) NOT NULL,
    `indirizzo` VARCHAR(255),
    `numero di telefono` VARCHAR(20),
    `email` VARCHAR(255),
    `data tesseramento` TIMESTAMP,
    `numero Tessera` VARCHAR(20),
    `storici acquisti` TEXT
);

-- Creazione della tabella "acquisto"
CREATE TABLE IF NOT EXISTS `acquisto` (
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `id_prodotto` varchar(255) NULL,
    `nome_prodotto` varchar(255) NULL,
    `prezzo_prodotto` decimal(10,2),
    `id_cliente` bigint,
    CONSTRAINT fk_cliente_acquisto
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

-- Creazione della tabella "sessione_acquisto"
CREATE TABLE IF NOT EXISTS `sessione_acquisto` (
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `data_inizio` TIMESTAMP NULL,
    `data_fine` TIMESTAMP NULL,
    `id_cliente` bigint,
    CONSTRAINT fk_cliente_sessione_acquisto
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

-- Creazione della tabella "fedelity_card"
CREATE TABLE IF NOT EXISTS `carta_fedeltà` (
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `Numero tessera` VARCHAR(20) NOT NULL,
    `Data di creazione tessera` TIMESTAMP,
    `punti` bigint DEFAULT 0,
    `cliente_id` bigint,
    `id_punto_vendita` bigint,
    CONSTRAINT fk_cliente_fedelity_card
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- Creazione della tabella "points_collection_campaign"
CREATE TABLE IF NOT EXISTS `campagna_punti` (
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `Nome Campagna` VARCHAR(255) NOT NULL,
    `Data Inizio` TIMESTAMP,
    `Data Fine` TIMESTAMP,
    `Conversione Punti/EURO` DECIMAL(10, 2)
);

-- Creazione della tabella "type_of_customer"
CREATE TABLE IF NOT EXISTS `tipo_cliente` (
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `tipo_cliente` VARCHAR(100) NOT NULL
);

-- creazione della tabella "azienda"
CREATE TABLE IF NOT EXISTS `azienda` (
     `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(255) NOT NULL,
    `regione` VARCHAR(255) NOT NULL,
    `città` VARCHAR(255) not null
);

-- creazione della tabella "tipologia_azienda"
CREATE TABLE IF NOT EXISTS `tipologia_azienda` (
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(255) NOT NULL,
    `descrizione` VARCHAR(255) NOT NULL -- ,
    -- `id_punto_vendita` bigint , credo sia superfluo
    -- ADD CONSTRAINT fk_punto_vendita 
    -- FOREIGN KEY (id_punto_vendita) REFERENCES punto_vandita(id)
);


-- Creazione della tabella "punto_vedinta"
CREATE TABLE IF NOT EXISTS `punto_vendita`(
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(255) NOT NULL,
    `città` VARCHAR(255) NOT NULL,
    `regione` VARCHAR(255) NOT NULL,
    `azienda_id` bigint,
    `tipologia_azienda_id` bigint,
    CONSTRAINT fk_azienda
    FOREIGN KEY (azienda_id) REFERENCES azienda(id),
    CONSTRAINT fk_tipologia_azienda
    FOREIGN KEY (tipologia_azienda_id) REFERENCES tipologia_azienda(id)
);

-- add costrain customer (fedelity_card)

ALTER TABLE cliente ADD COLUMN carta_fedeltà_id bigint;

ALTER TABLE cliente ADD CONSTRAINT fk_fedelity_card
FOREIGN KEY (carta_fedeltà_id) REFERENCES carta_fedeltà(id);

-- add costrain customer (type_of_customer)

ALTER TABLE cliente ADD COLUMN tipo_cliente_id bigint;

ALTER TABLE cliente ADD CONSTRAINT fk_tipo_cliente
FOREIGN KEY (tipo_cliente_id) REFERENCES tipo_cliente(id);

-- add costrain customer (punto_vedinta)

-- ALTER TABLE cliente ADD COLUMN azienda_id bigint;

-- ALTER TABLE cliente ADD CONSTRAINT fk_azienda
-- FOREIGN KEY (azienda_id) REFERENCES aziedna(id);

-- ALTER TABLE cliente ADD COLUMN tipologia_azienda_id bigint;

-- ALTER TABLE cliente ADD CONSTRAINT fk_tipologia_azienda
-- FOREIGN KEY (tipologia_azienda_id) REFERENCES tipologia_azienda(id);

-- insert biginto type_of_consumer

INSERT into `tipo_cliente` (`tipo_cliente`)
VALUES ('BUSINESS'), ('CONSUMATORE');
