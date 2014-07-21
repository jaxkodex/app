package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the conclusion database table.
 * 
 */
@Entity
@NamedQuery(name="Conclusion.findAll", query="SELECT c FROM Conclusion c")
public class Conclusion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_conclusion")
	private int idConclusion;

	@Lob
	@Column(name="conclusion_text")
	private String conclusionText;

	//bi-directional many-to-one association to Evaluacion
	@ManyToOne
	@JoinColumn(name="id_evaluacion")
	private Evaluacion evaluacion;

	public Conclusion() {
	}

	public int getIdConclusion() {
		return this.idConclusion;
	}

	public void setIdConclusion(int idConclusion) {
		this.idConclusion = idConclusion;
	}

	public String getConclusionText() {
		return this.conclusionText;
	}

	public void setConclusionText(String conclusionText) {
		this.conclusionText = conclusionText;
	}

	public Evaluacion getEvaluacion() {
		return this.evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

}