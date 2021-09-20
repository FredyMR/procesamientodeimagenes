package cargarimagen;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Marcos
 */
public class Histograma{

    
    /**
     * Calculamos la media de una variable Color
     * @param color Color del cual se quiere obtener la media
     * @return entero con el valor de la media
     */
    private int calcularMedia(Color color){
        int mediaColor;
        mediaColor=(int)((color.getRed()+color.getGreen()+color.getBlue())/3);
        return mediaColor;
    }
   int histogramaReturn[][]=new int[5][256];
   
    /**
     * Devuelve el histograma de la imagen.
     * @param imagen BufferedImagen de la cual se quiere obtener el histograma
     * @return Devuelve una variable int[5][256], donde el primer campo[0] corresponde
     * al canal Rojo, [1]=verde [2]=azul [3]=alfa [4]=escala grises
     
     */
    public int[][] histograma(BufferedImage imagen){
        Color colorAuxiliar;
        /*Creamos la variable que contendrá el histograma
        El primer campo [0], almacenará el histograma Rojo
        [1]=verde [2]=azul [3]=alfa [4]=escala grises*/
         
        //Recorremos la imagen
        for( int i = 0; i < imagen.getWidth(); i++ ){
            for( int j = 0; j < imagen.getHeight(); j++ ){
                //Obtenemos color del píxel actual
                colorAuxiliar=new Color(imagen.getRGB(i, j));
                //Sumamos una unidad en la fila roja [0], 
                //en la columna del color rojo obtenido
                //histogramaReturn[0][colorAuxiliar.getRed()]+=1;
                //histogramaReturn[1][colorAuxiliar.getGreen()]+=1;
                //histogramaReturn[2][colorAuxiliar.getBlue()]+=1;
                //histogramaReturn[3][colorAuxiliar.getAlpha()]+=1;
                histogramaReturn[4][calcularMedia(colorAuxiliar)]+=1;
                
                
            
            }
        }
        return histogramaReturn;
    }
    

int llenadoarreglo[]=new int[256];
    public void llenaVector (BufferedImage imageActual){
      Color colorAux;
          for (int i=0; i< imageActual.getWidth();i++)
                for (int j=0; j< imageActual.getHeight();j++)
                {
                    colorAux = new Color (imageActual.getRGB(i, j));
                    llenadoarreglo[colorAux.getBlue()]++;
                 }
}     
  public int minColor(){
       { for (int i=0;i<=255;i++)
            if (llenadoarreglo [i]!=0) 
            return i;
        return 255;
        }
  }
  
public int maxColor(){   
    for (int i = 255;i >=0;i--)
        if (llenadoarreglo[i]!=0) 
        return i;
 return 0;
 }
        
 public BufferedImage strecht(BufferedImage Imagen1){
      //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        this.llenaVector(Imagen1);
        int minimo=minColor();
        int maximo=maxColor();
        Color colorAux;
        BufferedImage imagenRetorno; //Comentado
        imagenRetorno = new BufferedImage (Imagen1.getWidth(), Imagen1.getHeight(), 1); //comentado
        float divisor = maximo-minimo;
       // System.out.println(maximo); 
       // System.out.println(minimo);
         //      System.out.println("---------------");
      //  int redondeado = Math.round(divisor);
       // int resultado=255-0;
        float a=0;
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < Imagen1.getWidth(); i++ ){
            for( int j = 0; j < Imagen1.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(Imagen1.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
               //System.out.println(colorAux.getBlue());
                a = (colorAux.getRed()-minimo);
               // System.out.println(a);
                a /=divisor; 
                 //System.out.println(a);
                a*=255;
                // System.out.println(a);
                 
                mediaPixel=Math.round(a);
                
                //System.out.println(mediaPixel);
                 //System.out.println("---------------");
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
 
 
     public BufferedImage compresion(BufferedImage Imagen1){
      //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        this.llenaVector(Imagen1);
        int minimo=minColor();
        //System.out.println(minimo);
        int maximo=maxColor();
        //System.out.println(maximo);
        Color colorAux;
        
        BufferedImage imagenRetorno; 
        imagenRetorno = new BufferedImage (Imagen1.getWidth(), Imagen1.getHeight(), 1); 
        float divisor = maximo-minimo;
        //System.out.println(divisor);
        //int redondeado = Math.round(divisor);
        int dividendo= 100-200;
        //System.out.println(dividendo);
        
        //System.out.println("---------------");
        
        float a=0;
        float b=0;
        float c=0;
        
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < Imagen1.getWidth(); i++ ){
            for( int j = 0; j < Imagen1.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(Imagen1.getRGB(i, j));
                //System.out.println(colorAux);
                //Calculamos la media de los tres canales (rojo, verde, azul)
                //mediaPixel = (colorAux.getRed());
                a=(dividendo/divisor);
                //System.out.println(a);
                
                b=(a*colorAux.getRed()-minimo);
                //System.out.println(b);
                
                //System.out.println("---------------");
                c=b+25;
                   
                mediaPixel=Math.round(c);
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

    public static int clamp(int value) {
        if(value < 0) return 0;
        else if(value > 255) return 255;
        return value;
    }
     
        
    public BufferedImage convolucion2 (BufferedImage imagenActual1,int numero){
        int mediaPixel,colorSRGB;
        Color colorAux1;
        int i,j;
        int[][]matrizColor=new int[3][3];
        BufferedImage imageRetorno;        
        imageRetorno = new BufferedImage(imagenActual1.getWidth(),imagenActual1.getHeight(),1);
        
        switch(numero){
            case 1:
            imageRetorno = new BufferedImage(imagenActual1.getWidth(),imagenActual1.getHeight(),1);

              int matrizConvolucion[][]=  {{-1,0,1},{-2,0,2},{-1,0,1}};
              for (i=1;i< imageRetorno.getWidth()-1;i++)
              for (j=1;j< imageRetorno.getHeight()-1;j++)
              {
                  for (int x=0,i1=i-1;x<3;x++,i1++)
                      for (int y=0,j1=j-1;y<3;y++,j1++)
                      {
                        colorAux1 = new Color (imagenActual1.getRGB(i1, j1));
                        matrizColor[x][y]=colorAux1.getRed();
                      }
                  int suma =0;
                  for (int x=0;x<3;x++)
                    for (int y=0;y<3;y++)
                      suma = suma + matrizConvolucion[x][y]*matrizColor[x][y];                 
                  if (suma > 255) mediaPixel = 255;
                  else if (suma < 0) mediaPixel = 0;
                  else mediaPixel = suma;
                  colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                 imageRetorno.setRGB(i, j,colorSRGB);
              }
         
            break;
            case 2:
                imageRetorno = new BufferedImage(imagenActual1.getWidth(),imagenActual1.getHeight(),1);
                int matrizConvolucion2[][]=  {{0,-1,0},{-1,5,-1},{0,-1,0}};
                for (i=1;i< imageRetorno.getWidth()-1;i++)
              for (j=1;j< imageRetorno.getHeight()-1;j++)
              {
                  for (int x=0,i1=i-1;x<3;x++,i1++)
                      for (int y=0,j1=j-1;y<3;y++,j1++)
                      {
                        colorAux1 = new Color (imagenActual1.getRGB(i1, j1));
                        matrizColor[x][y]=colorAux1.getRed();
                      }
                  int suma =0;
                  for (int x=0;x<3;x++)
                    for (int y=0;y<3;y++)
                      suma = suma + matrizConvolucion2[x][y]*matrizColor[x][y];                 
                  if (suma > 255) mediaPixel = 255;
                  else if (suma < 0) mediaPixel = 0;
                  else mediaPixel = suma;
                  colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                 imageRetorno.setRGB(i, j,colorSRGB);
              }
         
            break;
            case 3:
                imageRetorno = new BufferedImage(imagenActual1.getWidth(),imagenActual1.getHeight(),1);
                int matrizConvolucion3[][]=  {{-1,0,1},{-2,0,2},{-1,0,1}};
                for (i=1;i< imageRetorno.getWidth()-1;i++)
              for (j=1;j< imageRetorno.getHeight()-1;j++)
              {
                  for (int x=0,i1=i-1;x<3;x++,i1++)
                      for (int y=0,j1=j-1;y<3;y++,j1++)
                      {
                        colorAux1 = new Color (imagenActual1.getRGB(i1, j1));
                        matrizColor[x][y]=colorAux1.getRed();
                      }
                  int suma =0;
                  for (int x=0;x<3;x++)
                    for (int y=0;y<3;y++)
                      suma = suma + matrizConvolucion3[x][y]*matrizColor[x][y];                 
                  if (suma > 255) mediaPixel = 255;
                  else if (suma < 0) mediaPixel = 0;
                  else mediaPixel = suma;
                  colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                 imageRetorno.setRGB(i, j,colorSRGB);
              }
          break;
        }
               return imageRetorno;
    }

     public BufferedImage Rotacion (BufferedImage imageActual, double angulo){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        Color colorAux1;
        int i,j,i1,j1;
       
        BufferedImage imageRetorno;  
        
        angulo = Math.toRadians(angulo);
        float aCos= (float)Math.cos(angulo);
        float aSen= (float)Math.sin(angulo);
        imageRetorno = new BufferedImage(imageActual.getWidth(),imageActual.getHeight(),1);
        for (i=0; i< imageRetorno.getWidth();i++)
              for (j=0; j< imageRetorno.getHeight();j++)
              {
                  colorAux1 = new Color ( imageActual.getRGB(i, j));
                  mediaPixel = colorAux1.getRed();
                  colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                 i1 =  Math.round((i*aCos)-(j*aSen))-1;
                 j1 =  Math.round((i*aSen)+(j*aCos)-1);
                 if (i1>=0 && i1< imageRetorno.getWidth() &&
                     j1>=0 && j1< imageRetorno.getHeight())
                 imageRetorno.setRGB(i1, j1,colorSRGB);
                 //AffineTransform tx = AffineTransform.getRotateInstance(angulo, imageRetorno.getWidth()/2, imageRetorno.getHeight()/2);
              }
         return imageRetorno;
     }
     
     public BufferedImage ReflejoHorizontal (BufferedImage imageActual){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        Color colorAux1;
        int i,j,j1;
       
       BufferedImage imageRetorno;        
       imageRetorno = new BufferedImage(imageActual.getWidth(),imageActual.getHeight(),1);
        for (i=0; i< imageRetorno.getWidth();i++)
              for (j=0, j1 = imageRetorno.getHeight()-1; j< imageRetorno.getHeight();j++,j1--)
              {
                  colorAux1 = new Color ( imageActual.getRGB(i, j));
                  mediaPixel = colorAux1.getRed();
                  colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                 imageRetorno.setRGB(i, j1,colorSRGB);
              }
         return imageRetorno;
     }
     
     public BufferedImage ReflejoVertical (BufferedImage imageActual){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        Color colorAux1;
        int i,j,i1;
       
        BufferedImage imageRetorno;        
       imageRetorno = new BufferedImage(imageActual.getWidth(),imageActual.getHeight(),1);
        for (i=0, i1 = imageRetorno.getWidth()-1; i< imageRetorno.getWidth();i++,i1--)
              for (j=0; j< imageRetorno.getHeight();j++)
              {
                  colorAux1 = new Color ( imageActual.getRGB(i, j));
                  mediaPixel = colorAux1.getRed();
                  colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                 imageRetorno.setRGB(i1, j,colorSRGB);
              }
         return imageRetorno;
     }
}
   
