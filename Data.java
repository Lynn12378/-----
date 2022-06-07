import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;

public class Data
{
    private ArrayList<Book> books=new ArrayList<Book>();
	private ArrayList<Member> members=new ArrayList<Member>();

	private String BookTXT="Books.txt";
	private String MemberTXT="Members.txt";
	
	public String input,output;
	public String[] inputArray=new String[5];
	public String[] inputArray2=new String[4];
	int c=0;
	public void addBook(Book book)
	{
		try
		{
			FileWriter fw=new FileWriter(BookTXT);
			fw.append(book.toString());
			fw.flush();
        	fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();;
		}
	}
	public ArrayList<Book> readBooks()
	{
		try
		{
			FileReader fr = new FileReader(BookTXT);
			BufferedReader br = new BufferedReader(fr);
			while (br.ready())
			{
				input= br.readLine();
				inputArray=input.split("\t");
				books.add(new Book(inputArray[0],inputArray[1],inputArray[2],inputArray[3],inputArray[4]));
			}
			fr.close();	
			return books;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();;
		}
		return null;
	}
	public void addMember(Member member)
	{
		try
		{
			FileWriter fw = new FileWriter(MemberTXT,true);
        	fw.write(member.toString());
       		fw.flush();
        	fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();;
		}
        
	}
	public ArrayList<Member> readMembers()
	{
		try
		{
			FileReader fr = new FileReader(MemberTXT);
			BufferedReader br = new BufferedReader(fr);
			members=new ArrayList<>();
			while (br.ready())
			{	
				input= br.readLine();
				inputArray2=input.split("\t");
				members.add(new Member(inputArray2[0],inputArray2[1],inputArray2[2],inputArray2[3]));
			}
			fr.close();
			return members;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();;
		}
		return null;	
	}
	public void rewriteMembers(ArrayList<Member> members)
	{
		try
		{
			FileWriter fw = new FileWriter(MemberTXT,true);
			for(int i=0;i<members.size();i++){output+=members.get(i).toString();}
        	fw.write(output);
       		fw.flush();
        	fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();;
		}
	}
	public ArrayList<Member> getMembers(){return members;}
}