package records;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 
 * @author Schehat
 * Genre record
 */
public class Genre {
    private Long genreId;
    private String genre;
    
    /**
     * constructor with parameters
     * @param genreId
     * @param genre
     */
    public Genre (Long genreId, String genre) {
        setGenreId(genreId);
        setGenre(genre);
    }
    
    /*
     * empty constructor
     */
    public Genre() {
        
    }
    
    /**
     * 
     * @param genreId
     */
    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }
    
    /**
     * 
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    /**
     * 
     * @return genreId
     */
    public Long getGenreId() {
        return genreId;
    }
    
    /**
     * 
     * @return genre
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * insert Genre object to table 
     * @throws SQLException
     */
    public void insert() throws SQLException {
        // this means no custom id was set thus using a sequence
        if (genreId == null) {
            String getSeq = "SELECT genre_seq.nextval FROM DUAL";
            try (PreparedStatement seq = ConnectionManager.getConnection().prepareStatement(getSeq)) {
                try (ResultSet rs = seq.executeQuery()) {
                    rs.next();
                    genreId = rs.getLong("nextval");
                }
            } 
        }
        
        String SQL = "INSERT INTO Genre VALUES (?, ?)";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, genreId);
            
            if (genre != null) {
                stmt.setString(2, genre);
            } else {
                stmt.setNull(2, Types.NULL);
            }
            
            int n = stmt.executeUpdate();
            if (n != 1) {
                throw new SQLException("Insert failure with genreId = " + genreId);
                }
        }
    }
    
    /**
     * update existing tuples in table. Does not check if genreId exists (yet?)
     * @throws SQLException
     */
    public void update() throws SQLException {
        String SQL = "UPDATE Genre SET Genre = ? WHERE GenreId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            if (genre != null) {
                stmt.setString(1, genre);
            } else {
                stmt.setNull(1, Types.NULL);
            }
            
            stmt.setLong(2, genreId);
            
            int n = stmt.executeUpdate();           
            if (n != 1) {
                throw new SQLException("Update failure with genreId = " + genreId);
                }
        }
    }
    
    /**
     * deletes existing tuples in table. Does not check if genreId exists (yet?)
     * @throws SQLException
     */
    public void delete() throws SQLException {
        String SQL = "DELETE FROM Genre WHERE GenreId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, genreId);
            
            int n = stmt.executeUpdate();
            if (n != 1) {
                throw new SQLException("Delete failure with genreId = " + genreId);
                }
        } 
    }
}
