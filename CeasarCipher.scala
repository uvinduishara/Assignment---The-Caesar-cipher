

object CeasarCipher extends App{

	val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	
	val encrypt = (c:Char,shift:Int,a:String) => {
	  
	  if(a.indexOf(c.toUpper) != -1){
	    a( (a.indexOf(c.toUpper) + shift) % a.size );
	  }
	  else{
	    c
	  }
	  
	};
	
	val decrypt = (c:Char,shift:Int,a:String) => {
	  
	  if(a.indexOf(c.toUpper) != -1){
	    a( (a.indexOf(c.toUpper) + a.size - shift) % a.size );
	  }
	  else{
	    c
	  }
	  
	};
	
	val cipher = (algo:(Char,Int,String) => Char ,message:String,shift:Int,a:String) => message.map( algo(_,shift,a) );
	
	
	while(true){
	  
	  val inputShift = (scala.io.StdIn.readLine("Enter Shift Value For Encryption: ").toInt) % alphabet.size;

	  val encText = scala.io.StdIn.readLine("Enter Message: ");
	  
	  println( "Output: " + cipher(encrypt,encText,inputShift,alphabet) );
	  
	  val decText = scala.io.StdIn.readLine("\nEnter Decrypted Message: ");
	  
	  println( "Output: " + cipher(decrypt,decText,inputShift,alphabet) );
	  
	  println("****************************************************\n");
	  
	}
	
}