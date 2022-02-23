package nh.graphql.blogexample.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Nils Hartmann (nils@nilshartmann.net)
 */
@Component
public class DbImporter {

  private static final Logger logger = LoggerFactory.getLogger(DbImporter.class);

  private PostRepository postRepository;
  private UserRepository userRepository;

  public DbImporter(PostRepository postRepository, UserRepository userRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }

  @PostConstruct
  @Transactional
  public void importDb() {
    logger.info("Importing Database");

    final User U1 = userRepository.save(new User("U1", "nils", "Nils Hartmann", "..."));
    final User U2 = userRepository.save(new User("U2", "waldemar", "Waldemar Vasu", "secrept12"));
    final User U3 = userRepository.save(new User("U3", "karl", "Karl Marx", "gespenst"));
    final User U4 = userRepository.save(new User("U4", "alessa", "Alessa Bradley", "fasdfasdf"));
    final User U5 = userRepository.save(new User("U5", "lauren", "Lauren Jones", "vyxb"));

    final var P1 = new Post("P1", U1, "Learning GraphQL!", "lorem ipsum trallalala");
    P1.addComment(U2, "Cool post!");
    P1.addComment(U4, "Booooooooooring!");
    P1.addComment(U3, "Are you free? Because if you haven't it will only come out later.");
    P1.addComment(U4, "Busey ipsum dolor sit amet.");
    postRepository.save(P1);

    final var P2 = new Post("P2", U1, "Mastering GraphQL!", "nare ultimate mountains dead prejudice love salvation of selfish.");
    P2.addComment(U5, "Lousy");
    P2.addComment(U3, "Really nothing new!");
    postRepository.save(P2);

    final var P3 = new Post("P3", U1, "React best practices", "Blue bottle put a bird on it twee prism biodiesel brooklyn. Blue bottle ennui tbh succulents.");
    P3.addComment(U4, "Zombie ipsum reversus ab viral inferno, nam rick grimes malum cerebro. De carne lumbering animata corpora quaeritis. Summus brains sit, morbo vel maleficia");
    P3.addComment(U1, "De apocalypsi gorger omero undead survivor dictum mauris");
    postRepository.save(P3);

    final var P4 = new Post("P4", U1, "Beer or wine: what's best?", " Doner spare ribs andouille bacon sausage. Ground round jerky brisket pastrami shank.");
    postRepository.save(P4);

    final var P5 = new Post("P5", U1, "Spring and GraphQL: perfect match?", "Sit amet marshmallow topping cheesecake muffin. Halvah croissant candy canes bonbon candy. Apple pie jelly beans topping carrot cake danish tart cake cheesecake.");
    P5.addComment(U2, "Powder cake jujubes oat cake.");
    P5.addComment(U3, "Muffin danish chocolate soufflé pastry icing bonbon oat cake");
    P5.addComment(U4, "Powder cake jujubes oat cake. ");
    postRepository.save(P5);

    final var P6 = new Post("P6", U1, "Mastering GraphQL!", "nare ultimate mountains dead prejudice love salvation of selfish.");
    P6.addComment(U1, "Yeah, it's 8:00. Hey, McFly, I thought I told you never to come in here. Well it's gonna cost you. How much money you got on you?");
    P6.addComment(U4, "Many say exploration is part of our destiny, but it’s actually our duty to future generations and their quest to ensure the survival of the human species.");
    postRepository.save(P6);



  }

}
