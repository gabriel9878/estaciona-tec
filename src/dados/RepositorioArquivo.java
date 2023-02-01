package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import beans.Cliente;

public class RepositorioArquivo {
	
	public static void salvarArquivo(Object obj,String nomeArquivo) {
		
		if(obj == null) {
			
			return;
			
		}
		
		File output = new File(nomeArquivo);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			
			fos = new FileOutputStream(output);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}finally {
			
			if(oos != null) {
				
				try {
					
					oos.close();
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		}
	
	}
	

    
    public static Object lerDoArquivo(String nomeArquivo) {
    	
        Object obj = null;

        File in = new File(nomeArquivo);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
        	
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            
        } catch (Exception e) {
        	
        	e.printStackTrace();
        
        } finally {
        	
            if (ois != null) {
            	
                try {
                	
                    ois.close();
                    
                }catch (IOException e){
                	
                	
                }
            
            }
        
        }

        return obj;
    }
	
	/*public static void main(String[] args) {
		
		Cliente c = new Cliente();
		c.setCPF("10029432323");
		c.setDebito(234);
			
		salvarArquivo(c,"cachorro.arq");
		
		Cliente c1 = (Cliente) lerDoArquivo("cachorro.arq");
		
		System.out.println(c1.toString());
	
		
	}*/
	

}
