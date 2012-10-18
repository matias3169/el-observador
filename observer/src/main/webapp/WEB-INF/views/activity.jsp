<!-- #dialog is the id of a DIV defined in the code below -->
<div id="boxes"> 
	<!-- #customize your modal window here --> 
	<div id="dialog" class="window">
		<div id="headActivity">
		</div>
		<div id="bodyActivity">
			<div id="descriptionActivity">
				<p id="titulo"></p>
			</div>
			<div id="myGaleria">	
						
				<div id="multimedia">
					<ul id="gallery">	
								 	
						<li style="display: none"><img src="resources/img/cerrar_cuadrado_gris.png" /></li>
						<li style="display: none"><img src="resources/img/cerrar_cuadrado_gris.png" /></li>
						<li style="display: none"><img src="resources/img/cerrar_cuadrado_gris.png" /></li>
					</ul>
				</div>
				<div>
					<a id="ImageGallery" href="showImageGallery" target="_blank" >ImagesGallery</a>
					<a id="VideoGallery" href="showVideoGallery" target="_blank">VideosGallery</a>
				</div>			
			</div>
		</div>
		<div id="interactionActivity">
			<div>
				<img id="btnCerrar" src="resources/img/cerrar_cuadrado_gris.png" onclick="closeWindows()" width="25" height="25" />
			</div>
			<%@include file="initialComments.jsp" %>
		</div>
	</div>
	<!-- Do not remove div#mask, because you'll need it to fill the whole screen --> 
    <div id="mask"></div>

</div> 