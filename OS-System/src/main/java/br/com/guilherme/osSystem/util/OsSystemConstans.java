package br.com.guilherme.osSystem.util;

public class OsSystemConstans {
	
	public final static String TECNICO = "Tecnico";
	public final static String CLIENTE = "Cliente";
	public final static String CAMPO_NOME_OBRIGATORIO = "O campo NOME é obrigatório.";
	public final static String CAMPO_CPF_OBRIGATORIO = "O campo CPF é obrigatório.";
	public final static String CAMPO_TELEFONE_OBRIGATORIO = "O campo TELEFONE é obrigatório.";
	public final static String CPF_JA_CADASTRADO = "CPF já cadastrado na base de dados!";
	public final static String SAVE_SUCESSO = " criado com sucesso!";
	public final static String UPDATE_SUCESSO = " atualizado com sucesso!";
	public final static String DELETE_SUCESSO = " deletado com sucesso!";
	public final static String POSSUI_OS_NAO_PODE_DELETAR = " possui OS(s), portanto não pode ser deletado.";
	
	
	private OsSystemConstans() {
		throw new IllegalAccessError("This is a class of constants");
	}

}
