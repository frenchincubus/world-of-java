package fr.classe;

public interface Sort {

	/**
	 * retourne le nom du sort
	 * @return
	 */
	public String getNom();
	
	/**
	 * retourne la definition
	 * @return
	 */
	public String getDefinition();
	
	/**
	 * Le client lui-même ne sait pas ce que fait cette méthode (smiley se gratte le menton)
	 * @return
	 */
	public String information();
}
