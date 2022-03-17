package ipme.projet.ACCsetup.test.application;

import javax.persistence.*;

@Entity
@Table(name = "track")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trackId;

    @Column(name="")

}
