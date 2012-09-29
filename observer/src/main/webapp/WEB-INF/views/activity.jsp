<%@ include file="/WEB-INF/views/include.jsp" %>
<script type="text/javascript" src="resources/js/scripts.js"></script>
	
<!-- #dialog is the id of a DIV defined in the code below -->
<div id="boxes"> 
	<!-- #customize your modal window here --> 
	<div id="dialog" class="window">
		<div id="headActivity">
		</div>
		<div id="bodyActivity">
			<div id="descriptionActivity">
				<p>
				Dentro de esta actividad se buscara realizar.....asdadadadadadadadada
				asdadasdasd
				adadasdasada
				adasssd
				
				Dentro de esta actividad se buscara realizar.....asdadadadadadadadada
				asdadasdasd
				adadasdasada
				adasssd
				Dentro de esta actividad se buscara realizar.....asdadadadadadadadada
				asdadasdasd
				adadasdasada
				adasssd
				Dentro de esta actividad se buscara realizar.....asdadadadadadadadada
				asdadasdasd
				adadasdasada
				adasssd
				</p>
			</div>
			<div id="myGaleria">
				<div id="multimedia">				
					<ul id="gallery">
						<li style="display: none"><iframe width="420" height="315" src="http://www.youtube.com/embed/h-E6Lv9C6kI" frameborder="0" allowfullscreen></iframe></li>
						<li style="display: none"><img src="resources/img/cerrar_cuadrado_gris.png" /></li>
						<li style="display: none"><img src="resources/img/cerrar_cuadrado_gris.png" /></li>
						<li style="display: none"><img src="resources/img/book.png" data-frame="resources/img/cerrar_cuadrado_gris.png" alt="image" /></li>
					</ul>
				</div>
			</div>
		</div>
		<div id="inteactionActivity">
			<div>
				<img id="btnCerrar" src="resources/img/cerrar_cuadrado_gris.png" onclick="closeWindows()" width="25" height="25" />
			</div>
			<%@include file="initialComments.jsp" %>
		</div>
	</div>
	<!-- Do not remove div#mask, because you'll need it to fill the whole screen --> 
    <div id="mask"></div>
</div> 