package repository;

import domain.HasID;

import java.io.*;

public abstract class AbstractFileRepository<ID, E extends HasID<ID>> extends InMemoryRepository<ID, E> {
    private String fileName;

    public AbstractFileRepository(String fileName) {
        this.fileName = fileName;
        //this.loadData();
    }

    protected void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                E e = createEntity(line);
                super.save(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeData() {
        Iterable<E> iter = super.findAll();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.fileName, false))) {
            for (E entity : iter) {
                bw.write(entity.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract E createEntity(String line);
}
