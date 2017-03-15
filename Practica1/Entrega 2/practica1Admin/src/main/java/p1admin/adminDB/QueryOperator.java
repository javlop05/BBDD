package es.ucm.abd.tema2.bd;

public enum QueryOperator {
	LEQ("<="), LT("<"), GT(">"), GEQ(">="), EQ("="), NEQ("<>"), LIKE("LIKE");
	
	private String SQLrep;
	
	private QueryOperator(String rep) {
		this.SQLrep = rep;
	}
	
	@Override
	public String toString() {
		return SQLrep;
	}
}

