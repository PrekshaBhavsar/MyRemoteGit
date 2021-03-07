package ProjectCombo;

import java.util.Scanner;
import java.io.*;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.Iterator;


class AccountPassw{
	
	Scanner S =new Scanner(System.in);
	private String email;
	private String password;

	String MaskPass(String pass) {
		String maskpass =" ";
		for(int i = 0;i<pass.length();i++) {
			maskpass = maskpass + "*";
			System.out.println(maskpass);
		}
		return maskpass;
	}
	String Validate_email(String email_id) {
		boolean isvalidemail= Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$",email_id);
		while(!isvalidemail) {

			System.out.print("Enter valid Email Id: ");
			email_id = S.next();
			isvalidemail= Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$",email_id);
		}
		return email_id;
		
	}

//-------------------------------------------------------
	String userInput_Reg() throws IOException{
		String output = "";
		String name;
		String pass;
		String namepassstring;
		int index;
		boolean found = false; 
		
		//System.out.println("found status :"+found);
		
		try {
		System.out.println("Email Id : ");
		email = S.next();
		email = Validate_email(email);
		System.out.println("Password : ") ;
		password = S.next();
		
		//Account_Details_Save(email,password);     	   		

	        // Using file pointer creating the file. 
	        File file = new File("D:\\Simplilearn\\Projects\\Login.txt"); 

	        if (!file.exists()) { 
	             file.createNewFile(); // Create a new file if not exists. 
	        } 

	        // Opening file in reading and write mode. 
	       RandomAccessFile raf = new RandomAccessFile(file, "rw"); 
	       

	        // Checking whether the name of contact already exists. getFilePointer() give the current offset value from start of the file. 
	        while (raf.getFilePointer() < raf.length()) { 

	            // reading line from the file. 
	        	namepassstring = raf.readLine(); 

	            // finding the position of ',' 
	            index = namepassstring.indexOf(','); 

	            // separating name and number. 
	            name = namepassstring.substring(0, index); 
	            pass = namepassstring.substring(index + 1); 
	            
	            // if condition to find existence of record. 
	            if (name.equals(email)) { 
	                found = true;
	                output ="User already exists";
	                System.out.println(output);     
	                break; 
	            } 
	        }
	        //System.out.println("found status :"+found); 
	        if (found == false) {   
                // Enter the if block when a record is not already present in the file. 
	        	namepassstring = email + "," + password; 
  
                // writeBytes function to write a string as a sequence of bytes. 
                raf.writeBytes(namepassstring); 
  
                // To insert the next record in new line. 
                raf.writeBytes(System.lineSeparator()); 
  
                // Print the message 
                System.out.println(" Friend added. "); 
                System.out.println(output);
                // Closing the resources. 
                raf.close(); 
            } 
	               // The contact to be updated could not be found 
	        else { 
	            raf.close(); // Closing the resources. 

	            // Print the message 
	            //System.out.println(" Input name" + " does not exists. "); 
	        }  
		}//try termination
	    catch (IOException ioe) { 
	        System.out.println(ioe); 
	    } 
	    catch (NumberFormatException nef) { 
	        System.out.println(nef); 
	    } 
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return output;
	}
	void readFromFile_Login() throws FileNotFoundException {
	
		//file reader code
		String name;
		String pass;
		String namepassstring;
		int index;
		
		//boolean found = false;
		
		try { 
			System.out.print("Email ID : ");
			email = S.next();
			Validate_email(email);
			System.out.print("Password : ") ;
			password = S.next();
	        // Get the name of the contact to be updated from the Command line argument        	   		

	        // Using file pointer creating the file. 
	        File Rfile = new File("D:\\Simplilearn\\Projects\\Login.txt"); 

	        if (!Rfile.exists()) { 
	             //Rfile.createNewFile(); // Create a new file if not exists. 
	             System.out.print("No recoreds found at "+ Rfile.getAbsolutePath()+"or");
	        } 

	        // Opening file in reading and write mode. 
	        RandomAccessFile Rraf = new RandomAccessFile(Rfile, "rw"); 
	        boolean found = false; 

	        // Checking whether the name of contact already exists. getFilePointer() give the current offset value from start of the file. 
	        while (Rraf.getFilePointer() < Rraf.length()) { 

	            // reading line from the file. 
	        	namepassstring = Rraf.readLine(); 

	            // finding the position of '!' 
	            index = namepassstring.indexOf(','); 

	            // separating name and number. 
	            name = namepassstring.substring(0, index); 
	            pass = namepassstring.substring(index + 1); 

	            // if condition to find existence of record. 
	            if (name.equals(email) && pass.equals(password)) { 
	                found = true;
	                System.out.println("Login sucessfully!");
	                break; 
	            }
	        }
	        if (found == false) {    
	        	
	            // Print the message 
	        	//System.out.println("Invalid Email_ID/password"); 
	        	System.out.println("Enter valid Email ID and Password");
	        	readFromFile_Login(); 
	            // Closing the resources. 
	            Rraf.close(); 
	        } 
	               // The contact to be updated could not be found 
	        else { 
	            Rraf.close(); // Closing the resources. 

	            // Print the message 
	            //System.out.println(" Input name" + " does not exists. "); 
	        } 
	        } //try closing 
	        catch (IOException ioe) { 
	            System.out.println(ioe); 
	        } 
	        catch (NumberFormatException nef) { 
	            System.out.println(nef); 
	        } 
	        finally { 
	            //Rraf.close(); // Closing the resources. 
	            // Print the message 
	             
	        } 
		
}
}
class ListFiles {

	void List() {
		try {
			//create file object
			File file = new File("D:\\Simplilearn\\Projects");
		
			//get the list of files in given directory
			File[] files = file.listFiles();
		
			//list the files one by one
			/*for(int i =0;i<file.length();i++) {
			System.out.println(files[i].getName());
			}*/
			//sort the files using Treeset
		
			TreeSet<String> ts = new TreeSet<>();
		
			for(File x : files) {
				//String f1 = files[i].getName();
				ts.add(x.getName());		
			}
		
			System.out.println("Files are :");
		
			//Print all the files
			Iterator<String> iterator = ts.iterator();
		
			while(iterator.hasNext()) {
				System.out.println(iterator.next() + ",");
			}
		}
		catch(Exception e) {
			System.out.println(e.getCause());
		}
		
		}	
	}

class Addfiles {

	void Addf() throws IOException {
		try {
		String filename = null;
		String extension = null;
		Scanner S = new Scanner(System.in);
		System.out.println("Enter the file extension(eg .txt,.docx) : ");
		extension = S.nextLine();
		System.out.println("Enter the file name : ");
		filename = S.nextLine();				
		File file = new File("D:\\Simplilearn\\Projects\\"+filename +".txt");
		if(file.exists()) {
			System.out.println("file already exists.");
		}
		else {
		file.createNewFile();
		System.out.println("File "+filename+".txt"+" is successfully created!");
		}
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
class SearchFile {

	void Searchf() throws IOException {
		
		try {
			
			Scanner S = new Scanner(System.in);
			System.out.println("Enter the file name which you want to Search: ");
			String filename = S.nextLine();
			
			System.out.println("file searching...");
			File file = new File("D:\\Simplilearn\\Projects");
			
			
			//Filter filter based on name
			FilenameFilter filefilter = new FilenameFilter() {
				public boolean accept(File file,String name) {
					return name.contains(filename);
				}
			};
			//Take all filter files
			File[] files = file.listFiles(filefilter);			
			
			if(file.length() == 0) {
				System.out.println("File not found!");
			}
			else {
				
				//Display all the file names 
				for(int i=0;i<files.length;i++) {
				System.out.println(files[i].getName());
				}
				System.out.println("Total " + files.length +" files are found.");
			}				
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
	}}
class DeleteFiles {

	private static final boolean True = false;
	//private static final boolean True = false;

	void deletef()throws IOException {
		
		try {
			
		Scanner S = new Scanner(System.in);
		System.out.println("Enter the file name which you want to delete: ");
		String filename = S.nextLine();
		File file = new File("D:\\Simplilearn\\Projects");
		
		//Filter filter based on name
		FilenameFilter filefilter = new FilenameFilter() {
			public boolean accept(File file,String name) {
				return name.contains(filename);
			}
		};
		
		//Take all filter files
		File[] files = file.listFiles(filefilter);			
		
		if(files.length == 0) {
			System.out.println("File not found!");
		}
		else if(files.length == 1) {
			System.out.println(files[0].getName()+" is found.");
			System.out.print("Are you sure you want to delete the file?[Y/N]");
			//S.next().charAt(0)
			if(S.next().charAt(0) == 'Y') {
				File delfile = new File("D:\\Simplilearn\\Projects\\"+files[0].getName());
				System.out.println(delfile);
				delfile.delete();				
				System.out.println("file is deleted successfully.");
			}
			else {
				System.out.println("file is not deleted");
			}			
		}
		else {
			//Display all the file names 
			for(int i=0;i<files.length;i++) {
			System.out.println(files[i].getName());
			}
			System.out.println("Total " + files.length +" files are found.");
			boolean b = false;
			do
			{
			System.out.print("Which file you want to delete(Write with extension) ?");	
			String deletefilename = S.nextLine();
			File deletefile = new File("D:\\Simplilearn\\Projects\\"+deletefilename);
			
			if(deletefile.exists()) {
				deletefile.delete();				
				System.out.println("file deleted successfully.");
				b = True;
				break;
			}
			else {
				System.out.println("Plase enter the correct filename");
				b = false;
			}}while(b == True);
		}	
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	}
class InvalidChoiceException extends Exception{
	
	//private static final long serialVersionUID = 1L;
	InvalidChoiceException(String s){
	super(s);}
}
public class MainClass {
	static boolean isLoginValid = false;
	static void validate_login(int num1) throws InvalidChoiceException{
		if(num1 > 2 || num1 <= 0) {
        	throw new InvalidChoiceException("Enter valid choice from 1-2 :");
        }
        else {
        	isLoginValid = true;
        	//Do operation as specified
        }
	}
	
	static void validate(int num) throws InvalidChoiceException{
		if(num > 5 || num <= 0) {
        	throw new InvalidChoiceException("Enter valid choice from 1-5 :");
        }
        else {
        	//Do operation as specified
        }
	}
	public static void main(String data[]) throws IOException {
		AccountPassw obj = new AccountPassw();
		ListFiles ls = new ListFiles();
		Addfiles Ad = new Addfiles();
		DeleteFiles De = new DeleteFiles();
		SearchFile Sf = new SearchFile();
        int num1 = 1;
		String newuser;
        //Take user Option from the below mentioned Menu
        Scanner input = new Scanner(System.in);
       // while(!p) {
        System.out.println("****************************************************************");
        System.out.println("*********************  LOCKED ME. COM  ********************");
        System.out.println("****************************************************************");
        System.out.println("**********************Developer : Preksha Bhavsar*******************");
        System.out.println();
        

        
        while(!isLoginValid) {
            System.out.println(" 1.New User - Register");
            System.out.println(" 2.Already User - Login");
            System.out.println("Enter Your Choice:");
            //Add exception for input 1-2.
            num1 = input.nextInt();
            try {
            	validate_login(num1);
            }
            catch(Exception m){
            	System.out.println("Please Enter the number 1 to 2");
            }               
            switch(num1){    
            	case 1: System.out.println("Register"); 
       					newuser = obj.userInput_Reg();
       					if(newuser == "User already exists") {
       					isLoginValid = false;
       					continue;
       					}
       					else {
       						break;
       					}       			
            	case 2: System.out.println("Login");  
               			obj.readFromFile_Login();
               			break;
            	default: System.out.println("Please select 1 or 2 option");
            }
        } //while for login completes
//------------------------------------------------------------------------------------------------        
       boolean issubchoicevalid = false;
        while(!issubchoicevalid) {
        	System.out.println(" 1.See All files details of the directory");
        	System.out.println(" 2.Add the file ");
        	System.out.println(" 3.Delete the file");
        	System.out.println(" 4.Search the file");
        	System.out.println(" 5.Logout");
        
        	System.out.println("Enter Your Choice:");
        
        	//Add exception for input 1-5.
        	int num = input.nextInt();
        	try {
        		validate(num);
        	}
        	catch(Exception m){
        		System.out.println("Please Enter valid the number from 1 to 5");
        	}
         
           switch(num){    
            case 1: System.out.println("List all the files");  
            		ls.List();
            		break;
            case 2: System.out.println("Add file");  
    				Ad.Addf();
    				break;
            case 3: System.out.println("Delete file");  
    				De.deletef();
    				break;
            case 4: System.out.println("Search file");  
    				Sf.Searchf();
    				break;
            case 5: System.out.println("Logout");  
            		System.exit(0);
            		//p = true;
    				break;				
           default: System.out.println("Please select options from 1 to 5");  
           }
       }//Sub-choice while loop completes
	//}//main class while termination
    input.close();
	} //main class completes

}


