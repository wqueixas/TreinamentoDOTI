package br.queixas.spring02.dto;

public class ContagemStatusDto {
 
    private String agente;
    private int status;
    private long count;

    public ContagemStatusDto(String agente, int status, long count){
        this.agente = agente;
        this.status = status;
        this.count = count;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
    
}
