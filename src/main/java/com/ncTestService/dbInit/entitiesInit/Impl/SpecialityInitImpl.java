package com.ncTestService.dbInit.entitiesInit.Impl;

import com.ncTestService.dbInit.entitiesInit.SpecialityInit;
import com.ncTestService.models.Speciality;
import com.ncTestService.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpecialityInitImpl implements SpecialityInit {

    @Autowired
    SpecialityRepository specialityRepository;

    public void initSpecialities() {
        List<Speciality> list = new ArrayList<>();

        String BAfull = "<b>Business Intern Duties and Responsibilities</b><br>" +
                "<br>" +
                "Analyze business goals, objectives, and needs<br>" +
                "Help plan and design business processes and make recommendations for improvement<br>" +
                "Perform research and analysis in support of operations<br>" +
                "Assist in resolving business issues using systems and data<br>" +
                "Estimate costs and benefits of multiple actions and/or solutions and provide recommendations<br>" +
                "Help launch new initiatives<br>" +
                "May perform additional projects upon request<br>" +
                "<br>" +
                "<b>Requirements</b><br>" +
                "<br>" +
                "Business Administration or related major<br>" +
                "Minimum 3.0 GPA<br>" +
                "Experience with Microsoft Office<br>" +
                "Excellent critical thinking and problem-solving skills<br>" +
                "Good written and verbal communication skills<br>" +
                "Detail-oriented with strong organizational skills<br>" +
                "<br>" +
                "<b>Benefits</b><br>" +
                "<br>" +
                "Practical experience with varied business activities<br>" +
                "Shadowing, mentoring, and training opportunities with experienced and accomplished business professionals<br>" +
                "Opportunity to attend business meetings and networking events<br>" +
                "Flexible schedule for students<br>" +
                "Compensation available";

        String QAfull = "<b>Essential Job Functions:</b><br>" +
                "<br>" +
                "Develop functional manual test plans from requirement and product documentation.<br>" +
                "Create automated test scripts from existing QA test cases.<br>" +
                "Run tests based on detailed instructions with responsibility for trying to break the application, anticipating errors that a user could create and making sure that validations are in place to prevent these errors from crashing the program.<br>" +
                "Develop and execute test plans, test cases and test suites to support both manual and automated testing.<br>" +
                "Participate on projects as part of the QA Test team.<br>" +
                "Documents test results and maintains test records<br>" +
                "Designs and analyzes test cases and writes test procedures for implementing test cases<br>" +
                "Processes and coordinates testing information and enters data into standard QA documentation<br>" +
                "Other duties as assigned.<br>" +
                "<br>" +
                "<b>Education/Certifications:</b><br>" +
                "<br>" +
                "Pursuing a four-year degree or MS degree in Computer Science/Information Technology, Computer/Electrical Engineering or equivalent<br>" +
                "<br>" +
                "<b>Experience/Minimum Requirements:</b><br>" +
                "<br>" +
                "Must be eligible to work in the U.S. without sponsorship (now or in the future).<br>" +
                "Must have the demonstrated intellectual ability to grasp basic software testing concepts.<br>" +
                "Must have significant course work in Computer Science, Information Science, Information Systems or Information Technology.<br>" +
                "Good oral and written communications skills.<br>" +
                "Organized, detail-oriented and good interpersonal skills.<br>" +
                "Ability to work in a fast paced environment<br>" +
                "<br>" +
                "<b>Other Skills/Abilities:</b><br>" +
                "<br>" +
                "Experience with databases, SQL and Windows desired.<br>" +
                "Ability to write QA documentation, test cases, test strategies and summarize findings.<br>" +
                "Knowledge of automated testing tools is a plus";

        String DEVfull = "<b>Responsibilities</b> <br>" +
                "<br>" +
                "Contribute in all areas of software development – design, documentation, implementation and test, as well as, troubleshooting and support<br>" +
                "Work in a cross-functional environment to deliver a complete solution<br>" +
                "Provide estimates for technical effort<br>" +
                "Collaboration with stakeholders <br>" +
                "You will work with senior developers in the implementation of software applications using Agile development methodologies.<br>" +
                "Must be able and willing to work in a high energy, dynamic and fast paced development environment<br><br>" +
                "<b>Skills</b> <br>" +
                "<br>" +
                "Good verbal and written communication skills<br>" +
                "Object-Oriented design skills<br>" +
                "Preferred experience in programming with one or more of the following (Microsoft .NET, C++, C, Java, Python, Go)<br>" +
                "Debugging and trouble shooting skills<br>" +
                "Git or other source code management software<br>" +
                "Windows and Linux Operating Systems<br>" +
                "Knowledge of web Services (REST, JSON, XML, SOAP), multi-threaded programming, telecommunication networks (Layers 0-2) is an asset<br>" +
                "Self-motivated and willing to learn new technologies as needed<br>" +
                "<br>" +
                "<b>Benefits</b><br>" +
                "<br>" +
                "Rewarding experience. Meaningful outcomes.<br>" +
                "Making a difference in people's lives through design and implementation of leading network technologies. That's what motivates us.<br>" +
                "A distinct way to work<br>" +
                "Free thinking, free discussion, and collaboration are the norm. Expect more satisfying outcomes - both personal and professional.";

        try {

            list.add(new Speciality("DEV", "A developer  is a person who creates computer software. The term computer programmer can refer to a specialist in one area of computers, or to a generalist who writes code for many kinds of software or programs.", DEVfull));
            list.add(new Speciality("BA", "A business analyst (BA) is someone who analyzes an organization or business domain (real or hypothetical) and documents its business or processes or systems, assessing the business model or its integration with technology.", BAfull));
            list.add(new Speciality("QA", "It is a set of methods that try to ensure the quality of all projects in the software process. This includes procedures that administrators may use to review software and activities to verify that the software meets standards.", QAfull));

        } catch (Exception e) {
            e.printStackTrace();
        }

        specialityRepository.saveAll(list);

    }

}
