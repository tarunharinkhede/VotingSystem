import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VoterService {
    public void registerVoter(String voterId, String name, int age, String gender, String constituency, int boothNo) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String sql = "INSERT INTO voters(voter_id,name,age,gender,constituency, booth_no) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, voterId);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, gender);
            ps.setString(5, constituency);
            ps.setInt(6, boothNo);
            ps.executeUpdate();
            System.out.println("Voter registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasVoted(String voterId) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String sql = "SELECT has_voted FROM voters WHERE voter_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, voterId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getBoolean("has_voted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
