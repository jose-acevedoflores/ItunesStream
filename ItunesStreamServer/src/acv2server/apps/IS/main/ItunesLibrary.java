package acv2server.apps.IS.main;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * This class provides methods for accessing the Itunes Library file (C:\localhost\Music\Itunes\"Itunes Music Library.xml") 
 * @author Jose
 *
 */
public class ItunesLibrary {

	private Map<Integer, LibraryItem> imlItems;
	private File file; 
	/**
	 * 
	 * @param filename The location of the Itunes Music Library xml file
	 * @throws FileNotFoundException 
	 */
	public ItunesLibrary(String filename) throws FileNotFoundException
	{		
		//Initialize fields		
		this.file = new File(filename);
		this.imlItems = new HashMap<Integer, LibraryItem>();

		//Check if file exists
		if(file.exists())
		{
			this.parseFile();
		}

		else
			throw new FileNotFoundException("File "+filename+" was not found");

	}

	/**
	 * 
	 */
	public void print()
	{

	}

	public String getSongList()
	{
		LinkedList<String> songList = new LinkedList<String>();
		
		return null;
	}

	/*--------------------------------------------------------*/

	/**
	 * This methods takes the file and populates the Map 
	 * @throws FileNotFoundException 
	 */
	private void parseFile() throws FileNotFoundException {

		Scanner sc = new Scanner(file );
		sc.useDelimiter("<key>[0-9]+</key>");
		LibraryItem li;

		while(sc.hasNext())
		{
			li = new LibraryItem(sc.next());    // Create library Item for this item
			this.imlItems.put(li.getKey(), li); // Save the item in the map and use the Key assigned by itunes as the key value in the map
		}
		sc.close();
	}
}


