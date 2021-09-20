 
package cargarimagen;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Luis
 */
public class ProcesamientoImagen {
    
    //Imagen actual que se ha cargado
    //private BufferedImage imageActual;
    
    //Método que devuelve una imagen abierta desde archivo
    //Retorna un objeto BufferedImagen
    public BufferedImage abrirImagen(){
        //Creamos la variable que será devuelta (la creamos como null)
        BufferedImage bmp=null;
        //Creamos un nuevo cuadro de diálogo para seleccionar imagen
        JFileChooser selector=new JFileChooser();
        //Le damos un título
        selector.setDialogTitle("Seleccione una imagen");
        //Filtramos los tipos de archivos
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp");
        selector.setFileFilter(filtroImagen);
        //Abrimos el cuadro de diálog
        int flag=selector.showOpenDialog(null);
        //Comprobamos que pulse en aceptar
        if(flag==JFileChooser.APPROVE_OPTION){
            try {
                //Devuelve el fichero seleccionado
                File imagenSeleccionada=selector.getSelectedFile();
                //Asignamos a la variable bmp la imagen leida
                bmp = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
            }
                 
        }
        //Asignamos la imagen cargada a la propiedad imageActual
        //imageActual=bmp;
        //Retornamos el valor
        return bmp;
    }
    
     public BufferedImage escalaGrises(BufferedImage imageActual){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        Color colorAux;
        BufferedImage imagenRetorno;
        imagenRetorno = new BufferedImage (imageActual.getWidth(), imageActual.getHeight(), 1); //comentado
            
                
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < imageActual.getWidth(); i++ ){
            for( int j = 0; j < imageActual.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(imageActual.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel=(int)((colorAux.getRed()+colorAux.getGreen()+colorAux.getBlue())/3);
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB);
            }
        }
        //Retornamos la imagen
        return imagenRetorno;
    }
    
    public BufferedImage negativo(BufferedImage imageActual){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        Color colorAux;
        BufferedImage imagenRetorno; //Comentado
        imagenRetorno = new BufferedImage (imageActual.getWidth(), imageActual.getHeight(), 1); //comentado
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < imageActual.getWidth(); i++ ){
            for( int j = 0; j < imageActual.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(imageActual.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel=(int)((colorAux.getRed()+colorAux.getGreen()+colorAux.getBlue())/3);
                mediaPixel = 255 - mediaPixel;
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB); //comentado (imageActual)
            }
        }
        //Retornamos la imagen
        return imagenRetorno; // Retorno imageActual
    }
    
     public BufferedImage Suma(BufferedImage Imagen1, BufferedImage Imagen2){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB, minX, minY;
        Color colorAux1, colorAux2;
        BufferedImage imagenRetorno; //Comentado
        //comparación de medida para la imagen de salida
        minX = (Imagen1.getWidth()<Imagen2.getWidth())?
                Imagen1.getWidth(): Imagen2.getWidth();
        minY = (Imagen1.getHeight()<Imagen2.getHeight())?
                Imagen1.getHeight(): Imagen2.getHeight();
        
        imagenRetorno = new BufferedImage (minX, minY, 1);
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < minX; i++ ){
            for( int j = 0; j < minY; j++ ){
                //Almacenamos el color del píxel
                colorAux1=new Color(Imagen1.getRGB(i, j));
                colorAux2=new Color(Imagen2.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel = colorAux1.getRed() + colorAux2.getRed();
                if (mediaPixel > 255) mediaPixel = 255;
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB); //comentado (imageActual)
            }
        }
        //Retornamos la imagen
        return imagenRetorno; // Retorno imageActual
    }
     
     public BufferedImage Sumadivision(BufferedImage Imagen1, BufferedImage Imagen2){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB, minX, minY;
        Color colorAux1, colorAux2;
        BufferedImage imagenRetorno; //Comentado
        //comparación de medida para la imagen de salida
        minX = (Imagen1.getWidth()<Imagen2.getWidth())?
                Imagen1.getWidth(): Imagen2.getWidth();
        minY = (Imagen1.getHeight()<Imagen2.getHeight())?
                Imagen1.getHeight(): Imagen2.getHeight();
        
        imagenRetorno = new BufferedImage (minX, minY, 1);
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < minX; i++ ){
            for( int j = 0; j < minY; j++ ){
                //Almacenamos el color del píxel
                colorAux1=new Color(Imagen1.getRGB(i, j));
                colorAux2=new Color(Imagen2.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel = (int)((colorAux1.getRed()+colorAux2.getRed())/2);
                //if (mediaPixel > 255) mediaPixel = 255;
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB); //comentado (imageActual)
            }
        }
        //Retornamos la imagen
        return imagenRetorno; // Retorno imageActual
    }
     
     public BufferedImage Resta(BufferedImage Imagen1, BufferedImage Imagen2){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB, minX, minY;
        Color colorAux1, colorAux2;
        BufferedImage imagenRetorno; //Comentado
        //comparación de medida para la imagen de salida
        minX = (Imagen1.getWidth()<Imagen2.getWidth())?
                Imagen1.getWidth(): Imagen2.getWidth();
        minY = (Imagen1.getHeight()<Imagen2.getHeight())?
                Imagen1.getHeight(): Imagen2.getHeight();
        
        imagenRetorno = new BufferedImage (minX, minY, 1);
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < minX; i++ ){
            for( int j = 0; j < minY; j++ ){
                //Almacenamos el color del píxel
                colorAux1=new Color(Imagen1.getRGB(i, j));
                colorAux2=new Color(Imagen2.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel = colorAux1.getRed() - colorAux2.getRed();
                if (mediaPixel < 0) mediaPixel = 0;
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB); //comentado (imageActual)
            }
        }
        //Retornamos la imagen
        return imagenRetorno; // Retorno imageActual
    }
     
     public BufferedImage Absoluto(BufferedImage Imagen1, BufferedImage Imagen2){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB, minX, minY;
        Color colorAux1, colorAux2;
        BufferedImage imagenRetorno; //Comentado
        //comparación de medida para la imagen de salida
        minX = (Imagen1.getWidth()<Imagen2.getWidth())?
                Imagen1.getWidth(): Imagen2.getWidth();
        minY = (Imagen1.getHeight()<Imagen2.getHeight())?
                Imagen1.getHeight(): Imagen2.getHeight();
        
        imagenRetorno = new BufferedImage (minX, minY, 1);
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < minX; i++ ){
            for( int j = 0; j < minY; j++ ){
                //Almacenamos el color del píxel
                colorAux1=new Color(Imagen1.getRGB(i, j));
                colorAux2=new Color(Imagen2.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel = colorAux1.getRed() - colorAux2.getRed();
               /* if (mediaPixel < 0)*/ mediaPixel = (Math.abs(mediaPixel));
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB); //comentado (imageActual)
            }
        }
        //Retornamos la imagen
        return imagenRetorno; // Retorno imageActual
    }
     
     public BufferedImage SumaimagenesAnd(BufferedImage Imagen1, BufferedImage Imagen2){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB, minX, minY;
        Color colorAux1, colorAux2;
        BufferedImage imagenRetorno; //Comentado
        //comparación de medida para la imagen de salida
        minX = (Imagen1.getWidth()<Imagen2.getWidth())?
                Imagen1.getWidth(): Imagen2.getWidth();
        minY = (Imagen1.getHeight()<Imagen2.getHeight())?
                Imagen1.getHeight(): Imagen2.getHeight();
        
        imagenRetorno = new BufferedImage (minX, minY, 1);
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < minX; i++ ){
            for( int j = 0; j < minY; j++ ){
                //Almacenamos el color del píxel
                colorAux1=new Color(Imagen1.getRGB(i, j));
                colorAux2=new Color(Imagen2.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel = colorAux1.getRed() & colorAux2.getRed();
                //if (mediaPixel > 255) mediaPixel = 255;
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB); //comentado (imageActual)
            }
        }
        //Retornamos la imagen
        return imagenRetorno; // Retorno imageActual
    }
     
     public BufferedImage OR(BufferedImage Imagen1, BufferedImage Imagen2){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB, minX, minY;
        Color colorAux1, colorAux2;
        BufferedImage imagenRetorno; //Comentado
        //comparación de medida para la imagen de salida
        minX = (Imagen1.getWidth()<Imagen2.getWidth())?
                Imagen1.getWidth(): Imagen2.getWidth();
        minY = (Imagen1.getHeight()<Imagen2.getHeight())?
                Imagen1.getHeight(): Imagen2.getHeight();
        
        imagenRetorno = new BufferedImage (minX, minY, 1);
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < minX; i++ ){
            for( int j = 0; j < minY; j++ ){
                //Almacenamos el color del píxel
                colorAux1=new Color(Imagen1.getRGB(i, j));
                colorAux2=new Color(Imagen2.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel = colorAux1.getRed() | colorAux2.getRed();
                //if (mediaPixel > 255) mediaPixel = 255;
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB); //comentado (imageActual)
            }
        }
        //Retornamos la imagen
        return imagenRetorno; // Retorno imageActual
    }
     
     public BufferedImage XOR(BufferedImage Imagen1, BufferedImage Imagen2){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB, minX, minY;
        Color colorAux1, colorAux2;
        BufferedImage imagenRetorno; //Comentado
        //comparación de medida para la imagen de salida
        minX = (Imagen1.getWidth()<Imagen2.getWidth())?
                Imagen1.getWidth(): Imagen2.getWidth();
        minY = (Imagen1.getHeight()<Imagen2.getHeight())?
                Imagen1.getHeight(): Imagen2.getHeight();
        
        imagenRetorno = new BufferedImage (minX, minY, 1);
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < minX; i++ ){
            for( int j = 0; j < minY; j++ ){
                //Almacenamos el color del píxel
                colorAux1=new Color(Imagen1.getRGB(i, j));
                colorAux2=new Color(Imagen2.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel = colorAux1.getRed() ^ colorAux2.getRed();
                //if (mediaPixel > 255) mediaPixel = 255;
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB); //comentado (imageActual)
            }
        }
        //Retornamos la imagen
        return imagenRetorno; // Retorno imageActual
    }
     
    public BufferedImage Umbral(BufferedImage Imagen1, int dato){
      //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        Color colorAux;
        BufferedImage imagenRetorno; //Comentado
        imagenRetorno = new BufferedImage (Imagen1.getWidth(), Imagen1.getHeight(), 1); //comentado
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < Imagen1.getWidth(); i++ ){
            for( int j = 0; j < Imagen1.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(Imagen1.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel = colorAux.getRed();
                if (mediaPixel < dato) 
                    mediaPixel = 0;
                else
                    mediaPixel = 255;
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB); //comentado (imageActual)
            }
        }
        //Retornamos la imagen
        return imagenRetorno; // Retorno imageActual
    }
    
    public BufferedImage UmbralInverso(BufferedImage Imagen1, int dato){
      //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        Color colorAux;
        BufferedImage imagenRetorno; //Comentado
        imagenRetorno = new BufferedImage (Imagen1.getWidth(), Imagen1.getHeight(), 1); //comentado
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < Imagen1.getWidth(); i++ ){
            for( int j = 0; j < Imagen1.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(Imagen1.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel = colorAux.getRed();
                if (mediaPixel < dato) 
                    mediaPixel = 255;
                else
                    mediaPixel = 0;
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB); //comentado (imageActual)
            }
        }
        //Retornamos la imagen
        return imagenRetorno; // Retorno imageActual
    }
    
    public BufferedImage imagensumanumero(BufferedImage Imagen1, int dato){
      //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        Color colorAux;
        BufferedImage imagenRetorno; //Comentado
        imagenRetorno = new BufferedImage (Imagen1.getWidth(), Imagen1.getHeight(), 1); //comentado
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < Imagen1.getWidth(); i++ ){
            for( int j = 0; j < Imagen1.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(Imagen1.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel = ((int)((colorAux.getRed()+colorAux.getGreen()+colorAux.getBlue())/3))+dato;
                if (mediaPixel < dato) mediaPixel = 255;
                
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB); //comentado (imageActual)
            }
        }
        //Retornamos la imagen
        return imagenRetorno; // Retorno imageActual
    }
    
    
    public BufferedImage imagenrestanumero(BufferedImage Imagen1, int dato1){
      //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        Color colorAux;
        BufferedImage imagenRetorno; //Comentado
        imagenRetorno = new BufferedImage (Imagen1.getWidth(), Imagen1.getHeight(), 1); //comentado
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < Imagen1.getWidth(); i++ ){
            for( int j = 0; j < Imagen1.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(Imagen1.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel = ((int)((colorAux.getRed()+colorAux.getGreen()+colorAux.getBlue())/3))- dato1;
                if (mediaPixel > 255) mediaPixel = 255;
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB); //comentado (imageActual)
            }
        }
        //Retornamos la imagen
        return imagenRetorno; // Retorno imageActual
    }
    
    
    public BufferedImage imagendivisionnumero(BufferedImage Imagen1, int dato1){
      //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        Color colorAux;
        BufferedImage imagenRetorno; //Comentado
        imagenRetorno = new BufferedImage (Imagen1.getWidth(), Imagen1.getHeight(), 1); //comentado
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < Imagen1.getWidth(); i++ ){
            for( int j = 0; j < Imagen1.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(Imagen1.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel = ((int)((colorAux.getRed()+colorAux.getGreen()+colorAux.getBlue())/3))/dato1;
                if (mediaPixel < dato1) 
                    mediaPixel = 255;
                else
                    mediaPixel = 0;
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB); //comentado (imageActual)
            }
        }
        //Retornamos la imagen
        return imagenRetorno; // Retorno imageActual
    }
    
    
    
   public BufferedImage imagenmultiplicacionnumero(BufferedImage Imagen1, int dato1){
      //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        Color colorAux;
        BufferedImage imagenRetorno; //Comentado
        imagenRetorno = new BufferedImage (Imagen1.getWidth(), Imagen1.getHeight(), 1); //comentado
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < Imagen1.getWidth(); i++ ){
            for( int j = 0; j < Imagen1.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(Imagen1.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel = (int)((colorAux.getRed()+colorAux.getGreen()+colorAux.getBlue())/3)*dato1;
                if (mediaPixel > 255) mediaPixel = 255;
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imagenRetorno.setRGB(i, j,colorSRGB); //comentado (imageActual)
            }
        }
        //Retornamos la imagen
        return imagenRetorno; // Retorno imageActual
    }
   
   

    }
   
   
