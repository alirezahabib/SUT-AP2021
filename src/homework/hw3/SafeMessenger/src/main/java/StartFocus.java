import picocli.CommandLine;

@CommandLine.Command(
        name = "--start", aliases = "-s",
        mixinStandardHelpOptions = true,
        description = "start the focus")
public class StartFocus implements Runnable {
    @Override
    public void run() {
        boolean hasUsername = username != null && !username.equals("");
        boolean hasPort = port != 0;
        boolean hasHost = host != null && !host.equals("");
        Controller controller = Controller.controller;

        if (hasHost) controller.focus(host);
        if (hasPort) controller.focus(port);
        if (hasUsername) controller.focusOnContact(username);
        System.out.println("success");
    }

    @CommandLine.Option(names = {"--username", "-u"})
    String username;

    @CommandLine.Option(names = {"--port", "-p"})
    int port;

    @CommandLine.Option(names = {"--host", "-ht"})
    String host;
}
