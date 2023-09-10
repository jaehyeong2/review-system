package jjfactory.common.review.infra.peer;

import jjfactory.common.global.exception.ResourceNotFoundException;
import jjfactory.common.review.domain.peer.PeerReviewer;
import jjfactory.common.review.domain.peer.PeerReviewerReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@RequiredArgsConstructor
@Component
public class PeerReviewerReaderImpl implements PeerReviewerReader {
    private final PeerReviewerRepository peerReviewerRepository;

    @Override
    public PeerReviewer getOrThrow(Long id) {
        return peerReviewerRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("peer reviewer not fond");
        });
    }

    @Override
    public List<PeerReviewer> getByUserIdAndMetaId(Long userId, Long metaId) {
        return peerReviewerRepository.findAllByUserIdAndMetaId(userId, metaId);
    }
}
