package gerzen777gmail.com.deserializer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import gerzen777gmail.com.model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class CsvUserDeserializer {
    public Collection<User> deserializer(File file) {
        Collection<User> userCollection = new ArrayList<>();
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = CsvSchema.emptySchema().withColumnSeparator(';').withHeader();

        File in = new File(file.getName());

        ObjectReader oReader = csvMapper.readerFor(User.class).with(csvSchema);
        try {
            MappingIterator<User> iterator = oReader.readValues(in);
            while(iterator.hasNext()) {
                userCollection.add(iterator.nextValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userCollection;
    }
}