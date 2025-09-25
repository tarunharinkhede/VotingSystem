import java.sql.Connection;
import java.sql.PreparedStatement;

public class VotingService {
    private VoterService voterService = new VoterService();

    public void castVote(String voterId, int boothNo, int electionYear) {
        if (voterService.hasVoted(voterId)) {
            System.out.println("This voter has already voted.");
            return;
        }

        try (Connection conn = DatabaseConnector.getConnection()) {
            String sql = "INSERT INTO voting_log(voter_id,booth_no,election_year) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, voterId);
            ps.setInt(2, boothNo);
            ps.setInt(3, electionYear);
            ps.executeUpdate();

            String update = "UPDATE voters SET has_voted = TRUE WHERE voter_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(update);
            ps2.setString(1, voterId);
            ps2.executeUpdate();

            System.out.println("Vote cast successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
