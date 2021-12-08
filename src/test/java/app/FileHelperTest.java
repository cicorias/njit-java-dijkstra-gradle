package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileHelperTest {
    @Test
    void test_one_line_file() throws IOException {
        FileHelper fh = new FileHelper();
        fh.ReadFile("src\\test\\java\\app\\testfile1.txt");
        assertEquals(1, fh.lines);

    }
    @Test
    void test_two_line_file() throws IOException {
        FileHelper fh = new FileHelper();
        fh.ReadFile("src\\test\\java\\app\\testfile2.txt");
        assertEquals(2, fh.lines);
        assertEquals(5, fh.columns);
    }

    @Test
    void test_two_line_mismatch_columns_file() {
        FileHelper fh = new FileHelper();
        
        IOException thrown = assertThrows(IOException.class, () ->{
            fh.ReadFile("src\\test\\java\\app\\testfile2.bad.txt");
        });

        assertEquals("all columns are not same failed at line " + 3, thrown.getMessage());
    }
}
