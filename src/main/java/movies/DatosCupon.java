package movies;

import java.time.LocalDate;

public class DatosCupon {

	private String name;
	private String lastname;
	private String dni;
	private String email;
	private String sala;
	private LocalDate fecha;

	public DatosCupon() {

	}

	public DatosCupon(String name, String lastname, String dni, String email) {
		this.name = name;
		this.lastname = lastname;
		this.dni = dni;
		this.email = email;
	}

	public DatosCupon(String name, String lastname, String dni, String email, String sala, LocalDate fecha) {
		this.name = name;
		this.lastname = lastname;
		this.dni = dni;
		this.email = email;
		this.sala = sala;
		this.fecha = fecha;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DatosCupon that = (DatosCupon) o;

		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
		if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
		if (email != null ? !email.equals(that.email) : that.email != null) return false;
		if (sala != null ? !sala.equals(that.sala) : that.sala != null) return false;
		return fecha != null ? fecha.equals(that.fecha) : that.fecha == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
		result = 31 * result + (dni != null ? dni.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (sala != null ? sala.hashCode() : 0);
		result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
		return result;
	}
}
