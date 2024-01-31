package br.com.projeto.model;

import java.util.List;

public class NotasFaltas {

	//Atributos
		private int rgm1;
		private String disciplina1;
		private String semestre1;
		private String nota1;
		private String faltas1;
		
	
		
		
		public NotasFaltas() {
		
		}



		public NotasFaltas(int rgm1, String disciplina1, String nota1, String faltas1) {
			
			this.rgm1 = rgm1;
			this.disciplina1 = disciplina1;
			this.nota1 = nota1;
			this.faltas1 = faltas1;
		}



		public NotasFaltas(int rgm1, String disciplina1, String semestre1, String nota1, String faltas1) {
			this.rgm1 = rgm1;
			this.disciplina1 = disciplina1;
			this.semestre1 = semestre1;
			this.nota1 = nota1;
			this.faltas1 = faltas1;
			
			
			
		}



		public NotasFaltas(String disciplina1, String semestre1, String nota1, String faltas1) {
			super();
			this.disciplina1 = disciplina1;
			this.semestre1 = semestre1;
			this.nota1 = nota1;
			this.faltas1 = faltas1;
		}



		public int getRgm1() {
			return rgm1;
		}

		public void setRgm1(int rgm1) {
			this.rgm1 = rgm1;
		}

		public String getDisciplina1() {
			return disciplina1;
		}

		public void setDisciplina1(String disciplina1) {
			this.disciplina1 = disciplina1;
		}

		public String getSemestre1() {
			return semestre1;
		}

		public void setSemestre1(String semestre1) {
			this.semestre1 = semestre1;
		}

		public String getNota1() {
			return nota1;
		}

		public void setNota1(String nota1) {
			this.nota1 = nota1;
		}

		public String getFaltas1() {
			return faltas1;
		}

		public void setFaltas1(String faltas1) {
			this.faltas1 = faltas1;
		}
	
		
}
		
		//===============================================================================================
	