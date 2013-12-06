package com.mfino.tools.intlstringcollector;

import com.mfino.tools.intlstringcollector.exception.FileDataOutputWriterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class <code>FileDataOutputWriter</code> is an abstract class
 * which provides the abstract methods for the implementor to provide the
 * data to write and also the output directory details.
 *
 * Apart from mandating the implementor this class is responsible to write the
 * file data contents to a file that is created in the provided
 * output directory.
 *
 * @author Venkata Krishna Teja D
 */
public abstract class FileDataOutputWriter {

    /*
     * The Constant NEWLINE represents the NEWLINE character for this
     * operating system platform.
     *
     * For eg: On Windows its \r\n and on UNIX platform its \n
     *
     * NOTE: The access specifier for this constant is protected as we just want
     * the implementors to have access to this as and when its required.
     */
    protected static final String NEWLINE =
            System.getProperty("line.separator", "\n");


    /*
     * The constant OUTPUT_FILE_HEADER represents the Header string that
     * is to be written to the generated output file.
     */
    private static final String OUTPUT_FILE_HEADER =
            "# This file is generated by the custom tool." +
            NEWLINE + "# Please do not tamper with the data." +
            NEWLINE + NEWLINE;

    /*
     * The hashtable in which the placehold for the data that
     * is to be written to the file.
     *
     * The KEY - VALUE are in the following format.
     *
     * Type - 1 : FILEPATH LINE NUMBER - "the data to be translated"
     * Type - 2 : FILEPATH LINE NUMBER INSTANCE NUMBER =
     *                              "If there are multiple patterns in one line"
     */
    private Hashtable<String, String> dataStore;

    /*
     * The reference variable which repesents the Output file path
     * or the directory path.
     */
    private String outputFilePath;

    /*
     * Creates an instance of <code>FileDataOutputWriter</code>.
     */
    public FileDataOutputWriter() {
    }

    /*
     * Sets the data that is stored in the hastable.
     */
    public void setDataToWrite(Hashtable<String, String> dataStore) {
        this.dataStore = dataStore;
    }

    /*
     * Sets the output directory that is to be used to write the new file.
     */
    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    /*
     * Returns the data in the form of hashtable.
     */
    protected Hashtable<String, String> getDataStore() {
        return dataStore;
    }

    /*
     * Writes the got data into the desired file by prefixing the
     * OUTPUT_FILE_HEADER to the data packet.
     */
    public void writeDataToFile() throws FileDataOutputWriterException {
        String dataToWrite = getDataToWrite();
        String outputFileName = getFileName();

        File outputFile = new File(outputFilePath, outputFileName);

        // Check if the file is already present then
        // throw an exception.
        if(true == outputFile.exists()) {
            // Delete the file
            boolean deleted = outputFile.delete();
            if(false == deleted) {
                throw new FileDataOutputWriterException("The output file " +
                    outputFile.getAbsolutePath() + " already exists and" +
                    " the application is unable to delete it.");
            }
        }

        // We are trying 3 times to create the file.
        // If we cannot create the file in 3 times then
        // there is no point moving forward.
        // Throw an exception and let it propogate.
        for (int i = 0; i < 3; i++) {
            if (false == outputFile.exists()) {
                // Create a new file.
                boolean fileCreated = false;
                try {
                    fileCreated = outputFile.createNewFile();
                } catch (IOException ex) {
                    //LOG HERE.
                     Logger.getLogger(FileDataOutputWriter.class.getName()).
                        log(Level.SEVERE, null, ex);
                    continue;
                }
                if (fileCreated) {
                    break;
                }
            }
        }

        // Check if the file is created or not.
        if(false == outputFile.exists()) {
            throw new FileDataOutputWriterException(
                    "Unable to create the output file " +
                    outputFile.getAbsolutePath());
        }

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(outputFile);
        } catch (FileNotFoundException ex) {
            throw new FileDataOutputWriterException(
                    "The file " + outputFile.getAbsolutePath() +
                    " is not found or doesn't exist."+ NEWLINE + ex.getMessage());
        }
        
        try {
            fileOutputStream.write(dataToWrite.getBytes());
        } catch (IOException ex) {
            throw new FileDataOutputWriterException(
                    "Error occured while attempting to write the " +
                    "data to the file." + NEWLINE + ex.getMessage());
        }

        try {
            fileOutputStream.close();
        } catch (IOException ex) {
            // TODO :: Log here.
            // Do nothing as we are trying to close the connection.
            Logger.getLogger(FileDataOutputWriter.class.getName()).
                        log(Level.SEVERE, null, ex);
        }
    }

    /*
     * The abstract method which returns the data to write as
     * <code>String</code>.
     */
    public abstract String getDataToWrite() throws FileDataOutputWriterException;

    /*
     * The abstract method which returns the file name that is to generated.
     */
    public abstract String getFileName();
}
