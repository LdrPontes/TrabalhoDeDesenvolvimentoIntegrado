package Tarefa02;

import static org.jblas.FloatMatrix.*;
import static org.jblas.MatrixFunctions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.*;
import org.jblas.FloatMatrix;
import java.util.Random;

public class cgnr {
    public static void main(String[] args) throws IOException {

        FloatMatrix g = (FloatMatrix) loadCSVFile("G-1.csv");
        FloatMatrix H = (FloatMatrix) loadCSVFile("H-1.csv");
        FloatMatrix H_transpost = H.transpose();
        

        FloatMatrix image = FloatMatrix.zeros(3600, 1);

        FloatMatrix r = g.sub(H.mmul(image));
        FloatMatrix r_old;
        FloatMatrix z = H_transpost.mmul(r);
        FloatMatrix z_old;

        FloatMatrix p = z;

        Boolean flg = true;
        int i = 0;
        float a, b, error;
        FloatMatrix w;

        while (flg) {
            
            System.out.println("Iteracao: " + i);
            
            w = H.mmul(p);

            a = (z.norm2() * z.norm2()) / (w.norm2() * w.norm2()); 

            image = image.add(p.mul(a));

            r_old = r;
            r = r.sub(w.mul(a));

            error = r.norm2() - r_old.norm2();
            
            z_old = z;
            z = H_transpost.mmul(r);

            b = (z.norm2() * z.norm2()) / (z_old.norm2() * z_old.norm2());

            p = z.add(p.mul(b));

            System.out.println("erro: " + error);
            i++;
            
            if (i > 50)
                flg = false;

        }

        
        System.out.println("imagem: ");
        image.print();

    }
}
