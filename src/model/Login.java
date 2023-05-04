package model;
/**
 * @author tiago
 */
public class Login {
    private int ideObjeto;
    private String login;
    private String senha;

    public Login(int ideObjeto, String login, String senha) {
        this.ideObjeto = ideObjeto;
        this.login = login;
        this.senha = senha;
    }

    public Login() {
       
    }

    public int getIdeObjeto() {
        return ideObjeto;
    }

    public void setIdeObjeto(int ideObjeto) {
        this.ideObjeto = ideObjeto;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}
