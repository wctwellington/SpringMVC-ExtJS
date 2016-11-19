Ext.define('AlunoModel', {
	extend: 'Ext.data.Model',
	fields: [
	         { name: 'id', 			type: 'int' },
	         { name: 'nome',		type: 'string' },
	         { name: 'endereco',	type: 'string' },
	         { name: 'telefone',	type: 'int' },
	]
})