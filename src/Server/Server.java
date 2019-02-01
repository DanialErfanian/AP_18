package Server;

import Server.ChatRoom.Message;
import Server.ChatRoom.Room;
import Server.Communication.Results.GetProfileResult;
import Server.Communication.Results.RegisterResult;
import Server.User.AuthenticationProfile;
import Server.User.HostProfile;
import Server.User.RegisterProfile;
import Server.User.ScoreboardProfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Server {
    private HashMap<String, HostProfile> users = new HashMap<>();
    private Room globalRoom = new Room();
    private HashSet<HostProfile> scoreboardListeners = new HashSet<>();

    private Server() {
    }

    private static Server instance = new Server();

    public static Server getInstance() {
        return instance;
    }

    public Room getGlobalRoom() {
        return globalRoom;
    }

    public boolean authenticates(AuthenticationProfile authenticationProfile) {
        HostProfile hostProfile = users.get(authenticationProfile.getUsername());
        return hostProfile != null && hostProfile.getToken().equals(authenticationProfile.getToken());
    }

    public RegisterResult registerUser(RegisterProfile user) {
        HostProfile hostProfile = users.get(user.getUsername());
        if (hostProfile != null)
            return new RegisterResult(400, null);
        hostProfile = new HostProfile(user.getUsername(), user.getName());
        this.users.put(hostProfile.getToken(), hostProfile);
        // TODO send update to scoreboard listeners
        return new RegisterResult(hostProfile.toAuthenticationProfile());
    }

    public GetProfileResult getProfile(String username) {
        return new GetProfileResult(users.get(username));
    }

    public void sendMessageToUser(HostProfile user, Message message) {
        // TODO WHAT TO DO? :))
    }

    public void sendGlobalMessage(Message message) {
        globalRoom.addMessage(message);
    }

    public ArrayList<ScoreboardProfile> getScoreboard() {
        ArrayList<ScoreboardProfile> scoreboard = new ArrayList<>();
        for (HostProfile hostProfile : users.values()) {
            scoreboard.add(hostProfile.toScoreboardProfile());
        }
        scoreboard.sort((ScoreboardProfile u1, ScoreboardProfile u2) -> (u2.getMoney() - u1.getMoney()));
        return scoreboard;
    }

    public void updateMoney(String username, int money) {
        users.get(username).setMoney(money);
        // TODO send update to scoreboard listeners
    }
}
