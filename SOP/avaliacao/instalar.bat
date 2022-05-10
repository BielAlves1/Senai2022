echo off
md c:\site
md c:\site\imagens
md c:\site\paginas
cd instala_site
copy index.html c:\site
cd imagens
copy *.png c:\site\imagens
cd ..
cd paginas
copy *.html c:\site\paginas
cd ..
cd ..