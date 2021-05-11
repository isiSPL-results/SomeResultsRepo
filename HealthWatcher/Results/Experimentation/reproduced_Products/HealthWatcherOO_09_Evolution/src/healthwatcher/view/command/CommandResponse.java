package healthwatcher.view.command;
import java.io.IOException;
import java.io.PrintWriter;
public interface CommandResponse
{
    public PrintWriter getWriter() throws IOException;
}
