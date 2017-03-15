package abd.p1.model;

public enum Genero {
	Masculino("Masculino"), Femenino("Femenino"), Ambos("Ambos");
        
        private String genero;
        
        private Genero(String genero) {
            this.genero = genero;
        }
        
        public String toString() {
            return this.genero;
        }
        
        
}
