/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labthr;

/**
 *
 * @author andrei.nichita0308
 */
public class Message {
    private String content;

    public Message(String content) {
        this.content = content;
    }

    Message() {
         }

    public void setContent(String content) {
        this.content = content;
    }
    
    
    public String getContent() {
        return content;
    }
    //source map type string 
    //destination map type string
    
}
