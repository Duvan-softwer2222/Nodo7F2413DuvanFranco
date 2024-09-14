import java.util.ArrayList;
import java.util.List;

public class DocumentManager {
    private List<Document> documents;

    public DocumentManager() {
        this.documents = new ArrayList<>();
    }

    public void createDocument(String name) {
        documents.add(new Document(name));
    }

    public Document getDocument(String name) {
        for (Document document : documents) {
            if (document.getName().equalsIgnoreCase(name)) {
                return document;
            }
        }
        return null;
    }

    public void listDocuments() {
        System.out.println("Documentos disponibles:");
        for (Document document : documents) {
            System.out.println("- " + document.getName());
        }
    }
}
