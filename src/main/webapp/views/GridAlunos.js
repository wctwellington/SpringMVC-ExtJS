Ext.define('AlunoModel', {
	extend: 'Ext.data.Model',
	
	fields: [
	         { name: 'id', 			type: 'int' },
	         { name: 'nome',		type: 'string' },
	         { name: 'endereco',	type: 'string' },
	         { name: 'telefone',	type: 'string' },
	],
})

Ext.define('AlunoStore', {
	extend: 'Ext.data.Store',
	
	model: 'AlunoModel',
	proxy: {
		type: 'ajax',
		url: 'aluno/lerAlunos.html',
		reader: {
			method: 'POST',
			type: 'json',
			root: 'listaDeAlunos',
			rootProperty: 'success'
		}
	},
	autoLoad: true,
});

Ext.define('views.GridAlunos', {
	extend: 'Ext.grid.Panel',
	
	requires: ['Ext.util.Point'],
	title: 'Alunos',
	store: Ext.create('AlunoStore'),
	width: 1000,
	height: 500,
	columns: [
	         { text: 'ID', dataIndex: 'id', flex: 1, id: 'id' },
	         { text: 'Nome', dataIndex: 'nome', flex: 1 },
	         { text: 'Endereço', dataIndex: 'endereco', flex: 1 },
	         { text: 'Telefone', dataIndex: 'telefone', flex: 1 },
	]
	
});