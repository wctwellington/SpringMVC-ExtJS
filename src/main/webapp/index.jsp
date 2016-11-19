<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página Inicial</title>
<script type="text/javascript" src="views/extjs/ext-dev.js"></script>
<script type="text/javascript" src="views/extjs/locale/ext-lang-pt_BR.js"></script>
<link href="views/extjs/resources/ext-theme-classic/ext-theme-classic-all.css" rel="stylesheet" type="text/css"/>
</head>

<script type="text/javascript">

	Ext.onReady(function() {

		Ext.create('views.PanelCadastroAluno', {
			renderTo: 'principal',
		});

		Ext.create('views.GridAlunos', {
			renderTo: 'gridPanel',
		});
		
	});

</script>

<body>
	<div id="principal"></div>
	<div id="gridPanel"></div>
</body>
</html>