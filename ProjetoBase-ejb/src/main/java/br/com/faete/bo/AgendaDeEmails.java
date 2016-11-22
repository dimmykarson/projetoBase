/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.bo;

import java.io.Serializable;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author sticdev30
 */
@Singleton
@Startup
public class AgendaDeEmails implements Serializable{
    
    @Schedule(hour = "*", minute = "*", second = "*/30")
    public void enviarEmails(){
        System.out.println("Enviando emails...");
        System.out.println(">>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>");
        System.out.println("Emails enviados!");
    }
    
    
}
