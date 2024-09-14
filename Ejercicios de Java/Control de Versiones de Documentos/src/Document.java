import java.util.HashMap;
import java.util.Map;

public class Document {
    private String name;
    private String content;
    private int version;
    private Map<Integer, String> versionHistory;

    public Document(String name) {
        this.name = name;
        this.content = "";
        this.version = 0;
        this.versionHistory = new HashMap<>();
        saveVersion(); // Guardar la versión inicial (vacía)
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void modifyContent(String newContent) {
        this.content = newContent;
        saveVersion(); // Guardar una nueva versión cuando se modifica el contenido
    }

    private void saveVersion() {
        version++;
        versionHistory.put(version, content);
    }

    public String getVersion(int versionNumber) {
        return versionHistory.get(versionNumber);
    }

    public void restoreVersion(int versionNumber) {
        if (versionHistory.containsKey(versionNumber)) {
            content = versionHistory.get(versionNumber);
            System.out.println("Versión " + versionNumber + " restaurada.");
        } else {
            System.out.println("La versión solicitada no existe.");
        }
    }

    public void displayVersions() {
        System.out.println("Historial de versiones para el documento '" + name + "':");
        for (int v : versionHistory.keySet()) {
            System.out.println("Versión " + v + ": " + versionHistory.get(v));
        }
    }
}
