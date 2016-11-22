/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author sticdev30
 */
@ManagedBean
@ApplicationScoped
public class ChatMB implements Serializable {

    private Sala sala;
    private List<Sala> salas;

    @PostConstruct
    public void init() {
        salas = new ArrayList<>();
        salas.add(new Sala("Animes"));
        salas.add(new Sala("Futebol"));
        salas.add(new Sala("Festas"));
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public class Sala {

        private String nome;
        private Mensagem mensagem = new Mensagem();
        private List<Mensagem> mensagens = new ArrayList<>();

        public Sala(String nome) {
            this.nome = nome;
        }

        public synchronized void enviarMensagem() {
            mensagens.add(mensagem);
            mensagem = new Mensagem();
            Collections.sort(mensagens);
        }

        public Mensagem getMensagem() {
            return mensagem;
        }

        public void setMensagem(Mensagem mensagem) {
            this.mensagem = mensagem;
        }

        public List<Mensagem> getMensagens() {
            return mensagens;
        }

        public void setMensagens(List<Mensagem> mensagens) {
            this.mensagens = mensagens;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

    }

    public class Mensagem implements Comparable<Mensagem> {

        private String remetente;
        private String mensagem;
        private Calendar momento = Calendar.getInstance();
        private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        public String getData() {
            return sdf.format(momento.getTime());
        }

        public Calendar getMomento() {
            return momento;
        }

        public void setMomento(Calendar momento) {
            this.momento = momento;
        }

        public String getRemetente() {
            return remetente;
        }

        public void setRemetente(String remetente) {
            this.remetente = remetente;
        }

        public String getMensagem() {
            return mensagem;
        }

        public void setMensagem(String mensagem) {
            this.mensagem = mensagem;
        }

        @Override
        public int compareTo(Mensagem o) {
            if (this.momento.before(o.getMomento())) {
                return -1;
            } else {
                return +1;
            }
        }

    }

}
