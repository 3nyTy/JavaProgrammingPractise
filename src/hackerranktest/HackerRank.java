package hackerranktest;
/*public class ElectionWinner {

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









public class MergeStrings {

    public static void main(String[] args) {
        String a = "jygfk";
        String b = "kugyfdud";

        System.out.println(mergedString(a, b));
    }

    public static String mergedString(String a, String b) {
        List<Character> aCharList = new ArrayList<>();
        List<Character> bCharList = new ArrayList<>();

        char[] aChars = a.toCharArray();
        for(char aChar : aChars) {
            aCharList.add(aChar);
        }

        char[] bChars = b.toCharArray();
        for(char bChar : bChars) {
            bCharList.add(bChar);
        }

        Iterator<Character> aIter = aCharList.iterator();
        Iterator<Character> bIter = bCharList.iterator();
        StringBuilder sbr = new StringBuilder();

        while (aIter.hasNext() || bIter.hasNext()) {
            if (aIter.hasNext()) {
                sbr.append(aIter.next());
            }

            if (bIter.hasNext()) {
                sbr.append(bIter.next());
            }
        }

        return sbr.toString();
    }
}








public class MissingWords {

    public static void main(String[] args) {
        String s = "I like programming on Hacker Rank";
        String t = "like on Rank";
        
        List<String> missing = missingWords(s, t);
        missing.stream().forEach(m -> System.out.println(m));
    }
    
    public static List<String> missingWords(String s, String t) {
        List<String> missingWords = new ArrayList<>();
        
        List<String> sWords = Arrays.asList(s.split(" "));
        List<String> tWords = Arrays.asList(t.split(" "));
        
        Iterator<String> sIter = sWords.iterator();
        Iterator<String> tIter = tWords.iterator();
        
        while(tIter.hasNext()) {
            String tWord = tIter.next();
            boolean match = false;
            do {
                String sWord = sIter.next();
                if(!tWord.equals(sWord)) {
                    missingWords.add(sWord);
                } else {
                    match = true;
                }
            } while(!match);
        }
        
        while(sIter.hasNext()) {
            missingWords.add(sIter.next());
        }
        
        return missingWords;
    }
}

*/