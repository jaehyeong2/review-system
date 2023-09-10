package jjfactory.common.review.domain.peer;


import jjfactory.common.review.infra.peer.PeerReviewerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PeerReviewerWriterImpl implements PeerReviewerWriter {
    private final PeerReviewerRepository peerReviewerRepository;
    @Override
    public PeerReviewer write(PeerReviewer peerReviewer) {
        return peerReviewerRepository.save(peerReviewer);
    }

    @Override
    public void deleteById(Long id) {
        peerReviewerRepository.deleteById(id);
    }
}
