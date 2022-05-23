package com.progetto.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe che descrive un Farmaco trattato dall'Azienda o presente nel magazzino della Farmacia
 */
public class Farmaco implements Cloneable{


    private String nome;
    private String principioAttivo;
    private int tipo;
    private LocalDate dataScadenza;
    private int quantita;

    /**
     * Costruttore per un Farmaco trattato dall'Azienda.
     * L'attributo dataScadenda è inizializzato a null e l'attributo quantita è inizializzato a -1.
     * <p>
     * Il costruttore non effettua nessun controllo sulla validità dei parametri passati
     *
     * @param nome nome del farmaco
     * @param principioAttivo principio attivo del farmaco
     * @param tipo tipo del farmaco, 0 per farmaci da banco e 1 per farmaci particolari
     */
    public Farmaco(String nome, String principioAttivo, int tipo) {
        this.nome = nome;
        this.principioAttivo = principioAttivo;
        this.tipo = tipo;
        this.dataScadenza = null;
        this.quantita = -1;
    }

    /**
     * Costruttore per un Farmaco presente nel magazzino della Farmacia.
     * <p>
     * Il costruttore non effettua nessun controllo sulla validità dei parametri passati
     *
     * @param nome nome del farmaco
     * @param principioAttivo principio attivo del farmaco
     * @param tipo tipo del farmaco, 0 per farmaci da banco e 1 per farmaci particolari
     * @param dataScadenza data di scadenza del farmaco
     * @param quantita quantita del faramco
     */
    public Farmaco(String nome, String principioAttivo, int tipo, LocalDate dataScadenza, int quantita) {
        this.nome = nome;
        this.principioAttivo = principioAttivo;
        this.tipo = tipo;
        this.dataScadenza = dataScadenza;
        this.quantita = quantita;
    }

    public String getNome() {
        return nome;
    }

    public String getPrincipioAttivo() {
        return principioAttivo;
    }

    public int getTipo() {
        return tipo;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    /**
     * Metodo che ritorna l'attributo quantita di un oggetto Farmaco.
     * @return intero che rappresenta la quantita di un certo Faramco presente nel magazzino
     */
    public int getQuantita() {
        return quantita;
    }

    /**
     * Metodo che modifica l'attributo quantita di un oggetto Faramco.
     * Non effettua controlli sulla validità dei parametri passati.
     * @param quantita nuova quantita
     */
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    public Farmaco clone() throws CloneNotSupportedException {
        return (Farmaco)super.clone();
    }

    @Override
    public String toString() {
        String descTipo = tipo==0?"da banco":"particolare";
        if (dataScadenza == null || quantita == -1)  {
            return "Farmaco: " + nome + " di tipo " + descTipo + " col principio attivo "+ principioAttivo;
        } else {
            return "Farmaco: " + nome + " di tipo " + descTipo + " col principio attivo. Sono presenti " + quantita + " farmaci con scadenza " + dataScadenza.format(DateTimeFormatter.ofPattern("d//MM/uuuu"));
        }
    }
}

//LocalDate.of(2022, 05, 23).format(DateTimeFormatter.ofPattern("d/MM/uuuu"))
