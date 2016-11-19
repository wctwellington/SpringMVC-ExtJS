function salvarAluno() {
	var formulario = Ext.getCmp('formCadastroAluno');
	if (formulario.isValid()) {		
		Ext.Ajax.request({
			  url: '/aluno/salvarAluno.html',
			    method  : 'POST',
			    jsonData: formulario.getValues(),
			    
			    
			    	    success: function(response){
			    	
			    	    }			    			    
			    
			  })	
	}// formulario.isValid()
}

function limpar() {
	Ext.getCmp('formCadastroAluno').getForm().reset();
}

Ext.define('views.PanelCadastroAluno', {
	extend: "Ext.form.Panel",
	
	title: 'Formulário Cadastro Aluno',
	margin: 50,
	width: 610,
	height: 300,
	bodyStyle: 'padding: 30px',
	id: 'formCadastroAluno',
	defaults: {
    	margin: 20,
    	width: 500
    },
	items: [
	        {
	        	xtype: 'textfield',
	        	id: 'nome',
	        	name: 'nome',
	        	fieldLabel: 'Nome'	
	        },
	        {
	        	xtype: 'textfield',
	        	id: 'endereco',
	        	name: 'endereco',
	        	fieldLabel: 'Endereço'
	        },
	        {
	        	xtype: 'textfield',
	        	id: 'telefone',
	        	name: 'telefone',
	        	fieldLabel: 'Telefone'
	        },
	        {
	        	xtype: 'button',
	        	id: 'btnSalvar',
	        	text: 'SALVAR',
	        	width: 150,
	        	handler: salvarAluno
	        },
	        {
	        	xtype: 'button',
	        	id: 'btnLimpar',
	        	text: 'LIMPAR',
	        	width: 150,
	        	region: 'west',
	        	handler: limpar
	        }
	] //items
});