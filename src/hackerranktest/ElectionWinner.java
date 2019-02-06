package hackerranktest;

import java.util.*;
import java.util.Map.Entry;

public class ElectionWinner {
    public static void main(String[] args) {

    }

    public String electionWinner(String[] votes) {
        Map<String, Integer> candidateToVotesMap = new HashMap<>();
        Map<Integer, List<String>> voteNumToCandidateMap = new HashMap<>();

        for (String vote : votes) {
            if (candidateToVotesMap.containsKey(vote)) {
                int voteCount = candidateToVotesMap.get(vote);
                candidateToVotesMap.put(vote, ++voteCount);
            } else {
                candidateToVotesMap.put(vote, 1);
            }
        }

        for (Entry<String, Integer> voteCountEntry : candidateToVotesMap.entrySet()) {
            List<String> candidates = voteNumToCandidateMap.get(voteCountEntry.getValue());
            if (candidates == null) {
                candidates = new ArrayList<>();
            }

            candidates.add(voteCountEntry.getKey());
            voteNumToCandidateMap.put(voteCountEntry.getValue(), candidates);
        }

        List<Integer> voteCounts = new ArrayList<>(voteNumToCandidateMap.keySet());
        Collections.sort(voteCounts, Collections.reverseOrder());
        int maxVoteCount = voteCounts.get(0);
        List<String> candidatesWithMaxVotes = voteNumToCandidateMap.get(maxVoteCount);
        Collections.sort(candidatesWithMaxVotes, Collections.reverseOrder());

        return candidatesWithMaxVotes.get(0);
    }
}
