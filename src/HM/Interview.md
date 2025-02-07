## Standard Interiew Questions for HM Round

1. Have you led a project from conception to deployment? Walk me through your approach.
- Talk About CLF, ARMS GEDS. Alignment with Stakeholders on req of APi endpoints over AWS, impacting deliverables. Involving. 

2. How do you mentor junior engineers on your team?
- Help them onboard to codebase, team specific servie knowledge
- Nudge them towards ways to solve a problem, instead of directly telling the solution.
- Developing into better engineers, by giving right feedback in Reviews and 1-1, giving anecdotes from personal exp.
- Instance of using AppConfig in system, SDE has already used it but somehow struggled to get it. Explained how appConfig works, he has understanding of codebase. asked to navigate on own and raise CR.

3. Can you describe a time when you had to influence stakeholders (PMs, designers, etc.) on a technical decision?
- I have curated design documents laying down 2 approaches for developing a model hosting pipeline for DLM. I recommended a yet optimal approach which was feeding our use-case and also meeting the tight deadline and also there was an option to use internal framework for model hosting or create one from sratch. I proposed use framework becuase they support out of the box features and considerng time, it's best. Its just we will be using there library framework and will have keep it upto date. they had 10s of clients in Amazon.
- Recently worked on NewsLetter subscription for users, discussion was about placement of CheckBox. I was well versed with web tool. and recommended only at thank you page. Adding on cart page was not adding value and also hindering UX.

4. 

5. How do you handle disagreements with peers or senior leadership regarding technical decisions?
- Talk about decisions you made in the CLF while building HLD of it. and possible approaches that u took in Design Reviews from external stakeholders. 
- Talk about hard decision you had to take while VI design. went ahead with SageMaker ASML Solution, instead of building from raw sagemaker APIs. Why it was better? from past experience, good community support.

6. How do you balance hands-on coding with leadership responsibilities?
- Balance -> tech contributor team enabler, focus on high impact tasks focussing on like team's OE health metrics in leadership meetings.
- Aligning goals with SDE in the team on key areas of improvement and tracking them on regular monthy or weekly basis and presenting to leadership. 

7. Problem-Solving & Decision-Making
   (Understanding analytical thinking and decision-making approach.)

Tell me about a time when you faced a major technical challenge. How did you overcome it?
- 
- Latency issue in model. similarityScore Issue - recompute everyTime. Identified we canccache the results on host.
How do you approach evaluating new technologies before integrating them into a system?
Can you describe a situation where you had to make a trade-off between performance and scalability?
- Had a hard limit on 500ms latency and system was made scalable to handle load using auto-scaling, but if needed to expand on support of multiple models. it would require some re-acrhitecture. to suppoort that.
What do you do when faced with an ambiguous problem with no clear solution?
5. LinkedIn-Specific & Behavioral Questions
   (Checking culture fit, values, and alignment with LinkedIn’s mission.)

Why do you want to work at LinkedIn?
LinkedIn values collaboration and diversity—how do you foster an inclusive engineering culture?
Have you worked on a product with millions of users? What challenges did you face?
Tell me about a time when you had to align engineering efforts with business goals.
If you had unlimited resources, what LinkedIn feature would you improve or build?