package daos;

import java.util.Calendar;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "usuarios", schema = "gbp_operacional")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private long id_usuario;

    @Column(name = "dni_usuario", nullable = false)
    private String dni_usuario;

    public String getDni_usuario() {
        return dni_usuario;
    }

    public void setDni_usuario(String dni_usuario) {
        this.dni_usuario = dni_usuario;
    }

    @Column(name = "nombre_usuario")
    private String nombre_usuario;

    @Column(name = "apellidos_usuario")
    private String apellidos_usuario;

    @Column(name = "tlf_usuario")
    private String tlf_usuario;

    @Column(name = "email_usuario")
    private String email_usuario;

    @Column(name = "clave_usuario")
    private String clave_usuario;

    @Column(name = "estaBloqueado_usuario")
    private boolean estaBloqueado_usuario;

    @Column(name = "fch_fin_bloqueo")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fch_fin_bloqueo;

    @Column(name = "fch_alta_usuario")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fch_alta_usuario;

    @Column(name = "fch_baja_usuario")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fch_baja_usuario;

    public Usuario(String dni_usuario, String nombre_usuario, String apellidos_usuario,
            String tlf_usuario, String email_usuario, String clave_usuario, boolean estaBloqueado_usuario,
            Calendar fch_fin_bloqueo, Calendar fch_alta_usuario, Calendar fch_baja_usuario) {
        super();
        this.dni_usuario = dni_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellidos_usuario = apellidos_usuario;
        this.tlf_usuario = tlf_usuario;
        this.email_usuario = email_usuario;
        this.clave_usuario = clave_usuario;
        this.estaBloqueado_usuario = estaBloqueado_usuario;
        this.fch_fin_bloqueo = fch_fin_bloqueo;
        this.fch_alta_usuario = fch_alta_usuario;
        this.fch_baja_usuario = fch_baja_usuario;

    }

    //para pruebas de insert por creacion de objeto
    public Usuario(String dni_usuario) {
        super();
        this.dni_usuario = dni_usuario;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario [id_usuario=" + id_usuario + ", dni_usuario=" + dni_usuario + ", nombre_usuario="
                + nombre_usuario + ", apellidos_usuario=" + apellidos_usuario + ", tlf_usuario=" + tlf_usuario
                + ", email_usuario=" + email_usuario + ", clave_usuario=" + clave_usuario + ", estaBloqueado_usuario="
                + estaBloqueado_usuario + ", fch_fin_bloqueo=" + fch_fin_bloqueo + ", fch_alta_usuario="
                + fch_alta_usuario + ", fch_baja_usuario=" + fch_baja_usuario + "]";
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellidos_usuario() {
        return apellidos_usuario;
    }

    public void setApellidos_usuario(String apellidos_usuario) {
        this.apellidos_usuario = apellidos_usuario;
    }

    public String getTlf_usuario() {
        return tlf_usuario;
    }

    public void setTlf_usuario(String tlf_usuario) {
        this.tlf_usuario = tlf_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getClave_usuario() {
        return clave_usuario;
    }

    public void setClave_usuario(String clave_usuario) {
        this.clave_usuario = clave_usuario;
    }

    public boolean isEstaBloqueado_usuario() {
        return estaBloqueado_usuario;
    }

    public void setEstaBloqueado_usuario(boolean estaBloqueado_usuario) {
        this.estaBloqueado_usuario = estaBloqueado_usuario;
    }

    public Calendar getFch_fin_bloqueo() {
        return fch_fin_bloqueo;
    }

    public void setFch_fin_bloqueo(Calendar fch_fin_bloqueo) {
        this.fch_fin_bloqueo = fch_fin_bloqueo;
    }

    public Calendar getFch_alta_usuario() {
        return fch_alta_usuario;
    }

    public void setFch_alta_usuario(Calendar fch_alta_usuario) {
        this.fch_alta_usuario = fch_alta_usuario;
    }

    public Calendar getFch_baja_usuario() {
        return fch_baja_usuario;
    }

    public void setFch_baja_usuario(Calendar fch_baja_usuario) {
        this.fch_baja_usuario = fch_baja_usuario;
    }

    
    
}
