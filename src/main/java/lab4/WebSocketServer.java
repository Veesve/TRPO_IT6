package lab4;

import lab4.model.URLParser;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.StringReader;

@ServerEndpoint("/stock")
public class WebSocketServer {
    @OnOpen
    public void onOpen(Session session) throws IOException {
        //  session.getBasicRemote().sendText("Соединение установлено. Прим. команды (price:BTC:RUB)");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.getBasicRemote().sendText("Некорректная команда! Прим. команды (price:BTC:RUB)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(Session session, String currencyInfo) {
        try (JsonReader reader = Json.createReader(new StringReader(currencyInfo))) {
            JsonObject jsonMessage = reader.readObject();
            String cryptoCurName = jsonMessage.getString("crypto");
            String currencyName = jsonMessage.getString("currency");
            URLParser parser = new URLParser();
            String price = parser.getPrice(cryptoCurName, currencyName);
            session.getBasicRemote().sendText(price);

        } catch (IOException e) {
            System.err.println("Error while parsing");
            e.printStackTrace();
        }
    }
}